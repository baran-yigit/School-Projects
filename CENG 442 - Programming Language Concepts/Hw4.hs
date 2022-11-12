--Baran Yigit 201711071 Hw4
module Hw4
where
--Question 1
reshape xs = foldr (\a b-> a ++ if b=="" then b else "" ++ b) "" xs
--End of Question 1 Answer

--Question 2
dropeven :: [a] -> [a]
dropeven xs = let g = iterate (\x -> (x + 1) `mod` 2) 0
  in
  foldr (\ (x, n) s -> if n == 1 then x : s else s) [] (zip xs g)
--End of Question 2 Answer

--Question 3
dropodd :: [a] -> [a]
dropodd xs = let g = iterate (\x -> (x + 1) `mod` 2) 1
  in
  foldr (\ (x, n) s -> if n == 1 then x : s else s) [] (zip xs g)
--End of Question 3 Answer

--Question 4
pairsum :: [Int] -> [Int]
pairsum [] = []
pairsum x = zipWith (+) (tail x) x
--End of Question 4 Answer

--Question 5
subset2 [] = [[]]
subset2 (x:xs) = [x:subset2 | subset2 <- subset2 xs] ++ subset2 xs
--End of Question 5 Answer