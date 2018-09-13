Feature: Tests wikipedia
      This a test for the wikipedia page

      Scenario Outline: Test wikipedia in english
      Given I open <browser>
      And I open wikipedia
      When I search <articleName>
      Then I should see <articleTitle> in the title

      Examples:
      |  browser  |  articleName |  articleTitle |
      |  "chrome" | "France" |  "France" |
      |  "chrome" |  "h2o" | "Properties of water" |
      |  "chrome" |  "Messi" | "Lionel Messi" |
