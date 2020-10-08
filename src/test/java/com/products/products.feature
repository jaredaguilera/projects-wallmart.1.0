Feature: Products Scenarios

Scenario: Test List of products
Given url 'http://localhost:8888/'
When method GET
Then status 200

Scenario: Test List of productsById
Given url 'http://localhost:8888/?id=123'
When method GET
Then status 200

Scenario: Test List of productsByBrandOrDescription
Given url 'http://localhost:8888/?id=tblb'
When method GET
Then status 200