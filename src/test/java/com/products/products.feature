Feature: Products Scenarios

Scenario: Test List of products
Given url 'http://localhost:8888/products/getproducts'
When method GET
Then status 200

Scenario: Test List of productsById
Given url 'http://localhost:8888/products/getproductsbyid/1'
When method GET
Then status 200