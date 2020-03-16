package com.conference.track;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProposalManagement {

  private List<ProposalList> proposalLists;

  public List<ProposalList> populateProposalList() {
    proposalLists = new ArrayList<ProposalList>();
    addProposals();
    for (ProposalList list : proposalLists) {
      System.out.println("NAME " + list.getDuration() + ", PRICE " + list.getTitle());
    }
    return proposalLists;
  }

  private void addProposals() {
    System.out.println("*** PLEASE ENTER 3 PROPOSALS FOR WHICH SCREENING IS DONE ***");
    for (int i = 0; i < 3; i++) {
      System.out.println("Enter Duration in minute for " + i + " proposal");
      try {
        Scanner durationScanner = new Scanner(System.in);
        int duration = (durationScanner.nextInt());
        System.out.println("Enter title");
        Scanner titleScanner = new Scanner(System.in);
        String title = (titleScanner.nextLine());
        proposalLists.add(new ProposalList(duration, title));
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
