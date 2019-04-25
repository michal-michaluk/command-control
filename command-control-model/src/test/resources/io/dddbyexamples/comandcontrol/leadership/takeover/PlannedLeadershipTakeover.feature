Feature: Planned leadership takeover

  DomainStory:
  New Superior initiates Handover Request giving Subordinate object
  based on known Command Hierarchy find current superior of Subordinate
  LeadershipHandover is started for subordinate, currentSuperior, newSuperior objects
  new command is visible on currentCommandList on New Superior
  message LeadershipHandover is send over communication Channel

  class UnnamedYellowCard {

  ObjectId newSuperior

  CommandHierarchy hierarchy
  CurrentCommandList currentCommandList
  CommunicationChannel communicationChannel

  void requestHandover(RequestHandover command)
  Optional<ObjectId> currentSuperior = hierarchy.superiorOfSubordinate(subordinate)
  if (currentSuperior.isEmpty()) {
  // ???
  }
  var newCommand = new LeadershipHandoverStarted(subordinate, currentSuperior, newSuperior)
  currentCommandList.addOutgoingCommand(newCommand)

  communicationChannel.send(newCommand)
  }

  class RequestHandover { // blue card
  ObjectId subordinate
  }

  class LeadershipHandoverStarted { // orange card
  ObjectId subordinate
  ObjectId currentSuperior
  ObjectId newSuperior
  }

  class CurrentCommandList { // green card

  }

  interface CommandHierarchy {

  Optional<ObjectId> superiorOfSubordinate(ObjectId subordinate)

  }

  interface CommunicationChannel {

  void send(LeadershipHandover commandToSend)

  }


  Scenario: New superior initiating handover
    Given "Current Superior" is controlling unit of "Subordinate"
    #from new superior perspective:
    When New Superior requests handover of Subordinate
    Then handover procedure starts and addresses Current Superior of Subordinate
    And current command list New Superior contains new order
    And message is send to Current Superior

    When "Wilco" message is received from "Current Superior"
    ...


  Scenario: New superior initiating handover
    Given "Current Superior" is controlling unit of "Subordinate"
    #from new superior perspective:
    When New Superior requests handover of Subordinate
    Then handover procedure starts and addresses Current Superior of Subordinate
    And current command list New Superior contains new order
    And message is send to Current Superior


  Scenario:
    Given handover was initialised and message sent to Current Superior
    When "Wilco" message is received from "Current Superior"
  ...

  Scenario: New superior initiating handover
    Given "Current Superior" is controlling unit of "Subordinate"
    #from new superior perspective:
    When New Superior requests handover of Subordinate
    Then handover procedure starts and addresses Current Superior of Subordinate
    And current command list New Superior contains new order
    And message is send to Current Superior

    #from current superior perspective:
    When Handover Requested message is received from New Superior
    Then current command list of Current Superior contains new order

    When Current Superior allows handover
    Then Wilco message is send to New Superior


    #TODO finish this scenario
    #from new superior perspective:
    #from subordinate perspective:

  Scenario: New superior initiating handover, Current Superior responds cantco
    Given Current Superior got handover Request order

    When Current Superior rejects handover request
    Then Cantco message is send to New Superior


    #TODO finish this scenario
    #from new superior perspective:
    #from subordinate perspective:

  Scenario: New superior initiating handover, Cantpro from Current Superior
    Given Current Superior is NOT controlling Subordinate
    #from new superior perspective:
    When New Superior requests handover of Subordinate
    Then handover procedure starts and addresses Current Superior of Subordinate
    And current command list New Superior contains new order
    And message is send to Current Superior

    #from current superior perspective:
    When Handover Requested message is received from New Superior
    Then cantpro message is sent to New Superior
    #TODO finish this scenario
    #from new superior perspective:


  Scenario: New superior initiating handover when Current Superior is unknown


  Scenario: Current superior initiating takeover

  Scenario: C2 to C2 negotiation over radio + New Superior and subordinate handover over Link16

  Scenario: C2 to C2 negotiation over Link16 + New Superior and subordinate handover over radio

  Scenario: Lost Contact with current superior and lookup for new superior

  Scenario: Distribution information about current mission

  Scenario: Presentation of unknown mission progress

  Scenario: Lost Contact during leadership takeover procedure 1

  Scenario: Lost Contact during leadership takeover procedure 2

  Scenario: Lost Contact during leadership takeover procedure 3
