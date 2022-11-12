--Baran Yigit 201711071 Hw3

--Question 1
splt [] n = ([],[])
splt (x:xs) n = (firstn (x:xs) (n) , tailn (x:xs) (n))

tailn x 0 = x
tailn [] _ = []
tailn (_:xs) n = tailn xs (n-1)

firstn _ 0 = []
firstn (x:xs) n = x : firstn xs (n-1)
--End of Question 1 Answer
 
--Question 2
rplct x n
	| n <= 0	 = []
	| otherwise	 = rplct x (n-1) ++ [x]
--End of Question 2 Answer

--Question 3
inStr x [] = -1
inStr x (y:ys)
    | x == y    = 0
    | otherwise = if index == -1 then -1 else 1 + index
    where
        index = inStr x ys
--End of Question 3 Answer

--Question 4
fib 0 = 0
fib 1 = 1
fib n = fibf n 0 1
fibf 0 x y = x
fibf n x y = fibf (n-1) y (x+y)
--End of Question 4 Answer

--Question 5
fiblist n = [fib x | x <- [1..n]]
--End of Question 5 Answer