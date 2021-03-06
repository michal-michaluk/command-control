Feature: Leadership takeover initiated by new superior perspective

  Domain Story:
  handover procedure start:
  New Superior initiates Handover Request giving Subordinate object
  based on known Command Hierarchy find current superior of Subordinate
  LeadershipHandover is started for subordinate, currentSuperior, newSuperior objects
  new command is visible on Given Commands on New Superior
  message Handover Request is send over communication Channel

  wilco of handover request or handover procedure is confirmed manually:
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
    Given objects:
      | alias            | internalID | link16ID | description    |
      | Current Superior | 12013      | A0013    | Ground control |
      | New Superior     | 19104      | A0104    | NATO AWACS     |
      | Subordinate      | 12066      | A0066    | F16            |

  Scenario: Full handover
    When "New Superior" requests handover of "Subordinate"
    Then handover procedure started on "New Superior" and addresses "Current Superior" and "Subordinate"
    And Given Commands of "New Superior" contains "Handover"
    And "Handover Request" message is send to "Current Superior"

    When "Wilco" message from "Current Superior" is received by "New Superior"
    Then status of "#1 Handover" on "New Superior"s Given Commands changes to "Wilco"
    And "Control Unit Change" message is send to "Subordinate"

    When "Wilco" message from "Subordinate" is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Wilco"

    When Status message from "Subordinate" confirming "New Superior" as CU is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Done"

  Scenario: New superior initiates handover, Current Superior responds Cantco
    Given handover procedure already started on "New Superior" and addresses "Current Superior" and "Subordinate"
    When "Cantco" message from "Current Superior" is received by "New Superior"
    Then status of "#1 Handover" on "New Superior"s Given Commands changes to "Cantco"
    And no message is send from "New Superior"

  Scenario: New superior initiates handover, Current Superior not responds
    Given handover procedure already started on "New Superior" and addresses "Current Superior" and "Subordinate"
    When not message from "Current Superior" was received by "New Superior"
    Then status of "#1 Handover" on "New Superior"s Given Commands changes to "Timeout"
    And no message is send from "New Superior"

  Scenario: Handover over link16, Subordinate responds Cantpro, Control Unit Change over radio
    Given handover procedure on "New Superior" is in control unit change stage, addressing "Current Superior" and "Subordinate"
    When "Cantpro" message from "Subordinate" is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Cantpro"
    And no message is send from "New Superior"

    Given "New Superior" gives "Subordinate" Control Unit Change order over radio

    When Status message from "Subordinate" confirming "New Superior" as CU is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Done"

  Scenario: Handover over radio, Control Unit Change over link16
    Given "New Superior" gives "Current Superior" Handover Request over radio
    When handover procedure is confirmed on "New Superior" and addresses "Current Superior" and "Subordinate"
    Then status of "#1 Handover" on "New Superior"s Given Commands changes to "Wilco"
    And "Control Unit Change" message is send to "Subordinate"

    When "Wilco" message from "Subordinate" is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Wilco"

    When Status message from "Subordinate" confirming "New Superior" as CU is received by "New Superior"
    Then status of "#2 Control Unit Change" on "New Superior"s Given Commands changes to "Done"


  Scenario: Current Superior initiating takeover

  Scenario: C2 to C2 negotiation over radio + New Superior and subordinate handover over Link16

  Scenario: C2 to C2 negotiation over Link16 + New Superior and subordinate handover over radio

  Scenario: New Superior initiating control unit change to Subordinate

  Scenario: Subordinate initiating control unit change to New Superior

  Scenario: Distribution information about current mission

  Scenario: Presentation of unknown mission progress
