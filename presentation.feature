Feature: Presentation
  Scenario: https://utoronto-my.sharepoint.com/:p:/g/personal/mahe_chen_mail_utoronto_ca/EYzCv06bSaxGitWeMAqm7NQBpSniX0LWkkss_c598KqB1g?e=tfEvLB
    Given I successfully run `url create foo`
    And I cd to "foo"
    When I successfully run `url build`
    Then I successfully run `./app`
