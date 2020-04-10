module Derivative where

data Expr = X  -- variable
          | S Float -- scalar
          | Expr :+: Expr -- sum
          | Expr :*: Expr -- product
          | Expr :-: Expr -- arithmetic minus
          | Umin Expr --unary minus
          | Expr :/: Expr -- division 
          | Expr :^: Float  -- exponent
          deriving (Show, Eq) 
          
--rules of taking derivative          
derivative' :: Expr -> Expr
derivative' X = S 1
derivative' (S _) = S 0
derivative' (Umin p) = Umin (derivative p)
derivative' (p :+: q) = (derivative p) :+: (derivative q)
derivative' (p :-: q) = (derivative p) :-: (derivative q)
derivative' (p :*: q) = (derivative p :*: q) :+: (p :*: derivative q)
derivative' (p :/: q) = (derivative p :/: q) :-: (p :*: derivative q) :/: (q :*: q)
derivative' (p :^: i) = (S i :*: (p :^: (i - 1.0))) :*: derivative p 

--patterns for simplifying expression
simplify :: Expr -> Expr 
simplify expression = case expression of
        -- recursively start simplifying
        (p :+: q) -> simplify' (simplify p :+: simplify q)
        (p :-: q) -> simplify' (simplify p :-: simplify q)
        (p :/: q) -> simplify' (simplify p :/: simplify q)
        (p :*: q) -> simplify' (simplify p :*: simplify q)
        (p :^: q) -> simplify' (simplify p :^: q)
        (Umin p) -> simplify' (Umin (simplify p))
        _ -> expression

-- edge cases: handling constants simplifying
simplify' expression = case expression of
        (S x :+: S y) -> S (x + y)
        (S x :-: S y) -> S (x - y)
        (S x :*: S y) -> S (x * y)
        (S x :/: S y) -> S (x / y)
        
        (S 0.0 :*: _) -> S 0.0
        (_ :*: S 0.0) -> S 0.0
        
        (S 0.0 :/: _) -> S 0.0
        
        (S 0.0 :+: p) -> simplify' p
        (p :+: S 0.0) -> simplify' p
        (p :-: S 0.0) -> simplify' p
        (S 0.0 :-: p) -> Umin (simplify' p)
        
        (S 1.0 :*: p) -> simplify' p
        (p :*: S 1.0) -> simplify' p
        (p :/: S 1.0) -> simplify' p
        
        (p :^: 0.0) -> S 1.0
        (p :^: 1.0) -> simplify' p
        
        Umin (Umin p) -> simplify' p
        _ -> expression

derivative :: Expr -> Expr
derivative = simplify . derivative' 

testExpression1 = ((S 1) :/: (X :+: (S 1))) 
testExpression2 = ((S 2) :+: (S 5 :*: X))
testExpression3 = ((S 3) :/: X :-: ((X :^: 4 :-: (S 3 :*: (X :^: 2)) :*: S 10)))

test = (derivative testExpression3 == ((S (-3.0) :/: (X :*: X)) :-: (((S 4.0 :*: (X :^: 3.0)) :-: (S 3.0 :*: (S 2.0 :*: X))) :*: S 10.0))) &&
                (derivative testExpression2 == (S 5.0)) && 
                        (derivative testExpression1 == (S (-1.0) :/: ((X :+: S 1.0) :*: (X :+: S 1.0))))