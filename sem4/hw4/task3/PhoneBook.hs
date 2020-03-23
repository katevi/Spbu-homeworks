import System.IO

data Person = Person { name::String,
                       phoneNumber::String
                     } deriving (Eq, Show)

main = do
    doLoop []
    
--By given name returns list of persons with such name and their numbers
getNumber :: [Person] -> String -> [Person]
getNumber persons enteredName = filter (\x -> enteredName == name x) persons

--By given number returns list of persons with such number
getName :: [Person] -> String -> [Person]
getName persons enteredNumber = filter (\x -> enteredNumber == phoneNumber x) persons

--Prints result of search by name or number: if nothing have found, prints special message
printResultOfSearch :: [Person] -> IO()
printResultOfSearch persons | persons /= [] = print persons
                            | otherwise = putStrLn "Nothing found for your request :("

--Prints current list of persons to file "phonebook.txt"
writeDataToFile :: String -> [Person] -> IO()
writeDataToFile fileName persons = do
        phoneBook <- openFile fileName AppendMode
        mapM_ (\x -> hPutStrLn phoneBook $ name x ++ " " ++ phoneNumber x) persons
        hClose phoneBook

--Reads from file list of lines, one line = information about one person    
readDataFromFile :: String -> IO [String]
readDataFromFile fileName = do
    contents <- readFile fileName
    return $ lines contents
    
--Parses each line from file to person's parameters, if person does not exist in current list, adds it in list
addPersonsFromFile :: [String] -> [Person] -> [Person]
addPersonsFromFile [] persons = persons
addPersonsFromFile (line:lines) persons = do
        let newPerson = Person {name = head $ words line, phoneNumber = last $ words line}
        if (elem newPerson persons) then addPersonsFromFile lines persons
                                    else addPersonsFromFile lines $ newPerson : persons 

--Dialogue with the user
doLoop :: [Person] -> IO ()
doLoop persons = do
    putStrLn "Enter a command 1,2,3,4,5 or 0 to quit:"
    command <- getLine
    case command of
        '0':_ -> return()
        '1':_ -> do
                putStrLn "Please, enter new subscriber's name:"
                newName <- getLine
                putStrLn "Please, enter new subscriber's phone number:"
                newPhoneNumber <- getLine
                doLoop $ Person {name = newName, phoneNumber = newPhoneNumber} : persons
                
        '2':_ -> do
                putStrLn "Please, enter subscriber's name whose number you want to find:"
                enteredName <- getLine
                printResultOfSearch $ getNumber persons enteredName
                doLoop persons
        '3':_ -> do
                putStrLn "Please, enter subscriber's number whose name you want to find:"
                enteredNumber <- getLine
                printResultOfSearch $ getName persons enteredNumber
                doLoop persons
        '4':_ -> do
                putStrLn "Saving data to the file..."
                writeDataToFile "phoneBook.txt" persons 
                doLoop persons
        '5':_ -> do
                putStrLn "Adding data from the file..."
                entries <- readDataFromFile "phoneBook.txt"
                doLoop $ addPersonsFromFile entries persons
        _ -> do
                putStrLn "Please, enter command correctly. Press 0,1,2,3,4 or 5"
                doLoop persons