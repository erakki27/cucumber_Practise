Feature: Myntra Search

Scenario Outline: Search for product
Given Launch Website
Given Select Women Section
When search with product dresses
Then Select Color and Brand "<Brand>"
Then Select product and click on it for order



Examples: 
| Brand |
| KASSUALLY |
| StyleCast |
| DressBerry |







