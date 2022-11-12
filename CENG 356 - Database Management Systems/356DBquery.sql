-->Given a customer by an email address, returns the product ids that have been ordered and paid by this
-->customer but not yet shipped.
SELECT p.ProductID 
FROM Product p     
	INNER JOIN OrderItem oi ON p.ProductID  = oi.ProductID     
	INNER JOIN Orders o ON o.OrderID  = oi.OrderID     
	INNER JOIN Customer c ON c.CustomerID  = o.CustomerID     
	INNER JOIN Invoice i ON i.InvoiceNumber  = o.InvoiceNumber 
WHERE oi.ItemStatus  <> 'shipped' AND i.InvoiceStatus = 'paid' 
	AND o.CustomerID  = (SELECT CustomerID     
	FROM Customer     
	WHERE Email  = 'baran09@hotmail.com')
	;

-->Find the 5 bestselling product type ids in terms of product quantity sold. The products of concerned have to
-->be ordered and paid.
SELECT TOP 5 
	(oi.ProductID) , SUM(oi.Quantity) AS TotalQuantity 
FROM ProductType pt     
	INNER JOIN Product p ON p.ProductTypeID  = pt.ProductTypeID     
	INNER JOIN OrderItem oi ON oi.ProductID = p.ProductID     
	INNER JOIN Orders o ON o.OrderID  = oi.OrderID     
	INNER JOIN Invoice i ON i.InvoiceNumber = o.InvoiceNumber 
WHERE i.InvoiceStatus = 'paid' 
GROUP BY oi.ProductID 
ORDER BY TotalQuantity DESC
;

-->Get 2 random customers and return their email addresses.
SELECT TOP 2 
	Email 
FROM Customer 
ORDER BY NEWID() 
;

-->Find customers that have one paid for at least an item from each restricted shop.
SELECT c.FullName 
FROM Customer c 
	JOIN Orders o ON o.CustomerID  = c.CustomerID 
	JOIN CreditCard cc ON cc.CustomerID  = c.CustomerID 
	JOIN OrderItem oi ON oi.OrderID  = o.OrderID 
	JOIN Invoice i ON i.InvoiceNumber = o.InvoiceNumber 
	JOIN Product p ON p.ProductID  = oi.ProductID 
	JOIN RestrictedShop rs ON rs.ProductTypeID  = p.ProductTypeID 
WHERE i.InvoiceStatus = 'paid' 
GROUP BY  c.FullName 
HAVING count(distinct rs.ShopID) =  (SELECT count(*) 
FROM RestrictedShop) 
;

-->Obtain gross sales for the shipped products of shops in the month of Febuary.
SELECT p.ShopID, SUM(oi.UnitPrice * oi.Quantity) AS GrossSale 
FROM OrderItem AS oi 
	JOIN Product AS p ON oi.ProductID = p.ProductID 
	JOIN Orders AS o ON o.OrderID = oi.OrderID 
WHERE month(OrderDate)='2' AND o.OrderStatus = 'shipped' 
GROUP BY p.ShopID 
ORDER BY GrossSale DESC
;