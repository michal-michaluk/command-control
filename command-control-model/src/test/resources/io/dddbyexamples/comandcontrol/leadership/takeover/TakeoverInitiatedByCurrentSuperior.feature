Feature: Leadership handover initiated by current superior form current superior perspective

  Domain Story:
  handover procedure start:
  "Current Superior initiates Handover procedure by sending handover request to Current Superior
  LeadershipHandover is started for subordinate, currentSuperior, newSuperior objects
  new command is visible on Given Commands on Current Superior
  message Handover Request is send over communication Channel

  wilco of handover request is confirmed manually by New Superior:
  status of command is changed to wilco
  message Control Unit Change is send over communication Channel

  wilco of control unit change:
  status of command is changed to wilco

  status from Subordinate:
  status of command is changed to done
  or error?

  cantpro / cantco / timeout of handover request:
  status of command is changed

  cantpro / cantco / timeout of control unit change:
  status of command is changed


  Background:
    Given "Current Superior" is controlling unit of "Subordinate"

  Scenario: Full handover initiated by Current Superior
    When "Current Superior" requests handover of "Subordinate" to "New Superior"
    Then handover procedure started on "Current Superior" and addresses "New Superior" and "Subordinate"
    And Given Commands of "Current Superior" contains "Handover"
    And "Handover Request" message is send to "New Superior"

    When "Wilco" message from "New Superior" is received by "Current Superior"
    Then status of "#1 Handover" on "Current Superior"s Given Commands changes to "Wilco"
    And "Control Unit Change" message is send to "Subordinate"

    When "Wilco" message from "Subordinate" is received by "Current Superior"
    Then status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Wilco"

    When Status message from "Subordinate" confirming "New Superior" as CU is received by "Current Superior"
    Then status of "Subordinate" on "Current Subordinate" Unit Statuses indicates "New Superior" as CU
    And status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Done"

  Scenario: Current superior initiates handover, New Superior responds Cantco
    Given handover procedure already started on "Current Superior" and addresses "New Superior" and "Subordinate"
    When "Cantco" message from "New Superior" is received by "Current Superior"
    Then status of "#1 Handover" on "Current Superior"s Given Commands changes to "Cantco"
    And no message is send from "Current Superior"

  Scenario: Current superior initiates handover, Subordinate responds Cantco
    Given handover procedure on "Current Superior" is in control unit change stage, addressing "New Superior" and "Subordinate"
    When "Cantco" message from "Subordinate" is received by "Current Superior"
    Then status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Cantco"
    And "Handover Termination" message is send to "New Superior"

    When "Wilco" message from "New Superior" is received by "Current Superior"
    Then status of "#1 Handover" on "Current Superior"s Given Commands changes to "Cancelled"

  Scenario: Current superior initiates handover, Subordinate responds Cantpro
    Given handover procedure on "Current Superior" is in control unit change stage, addressing "New Superior" and "Subordinate"
    When "Cantpro" message from "Subordinate" is received by "Current Superior"
    Then status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Cantpro"
    And "Handover Termination" message is send to "New Superior"

    When "Wilco" message from "New Superior" is received by "Current Superior"
    Then status of "#1 Handover" on "Current Superior"s Given Commands changes to "Cancelled"

  Scenario: Handover over link16, Subordinate responds Cantpro, Control Unit Change over radio
    Given handover procedure on "Current Superior" is in control unit change stage, addressing "New Superior" and "Subordinate"
    When "Cantpro" message from "Subordinate" is received by "Current Superior"
    Then status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Cantpro"
    And no message is send from "Current Superior"

    Given "Current Superior" gives "Subordinate" Control Unit Change order over radio

    When Status message from "Subordinate" confirming "Current Superior" as CU is received by "Current Superior"
    Then status of "Subordinate" on "Current Subordinate" Unit Statuses indicates "New Superior" as CU
    And status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Done"

  Scenario: Handover over radio, Control Unit Change over link16
    Given "Current Superior" gives "New Superior" Handover Request over radio
    When handover procedure is confirmed on "Current Superior" and addresses "New Superior" and "Subordinate"
    Then status of "#1 Handover" on "Current Superior"s Given Commands changes to "Wilco"
    And "Control Unit Change" message is send to "Subordinate"

    When "Wilco" message from "Subordinate" is received by "Current Superior"
    Then status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Wilco"

    When Status message from "Subordinate" confirming "New Superior" as CU is received by "Current Superior"
    Then status of "Subordinate" on "Current Subordinate" Unit Statuses indicates "New Superior" as CU
    And status of "#2 Control Unit Change" on "Current Superior"s Given Commands changes to "Done"
