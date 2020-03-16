package com.conference.track;

import com.conference.algorithm.FirstFitDecreasing;

import java.util.Arrays;
import java.util.List;

public class Application {

  private static List<ProposalList> proposalLists;

  public static void main(String[] args) {

    // getAllApprovedProposals();
    List<ProposalList> proposalLists =
        Arrays.asList(
            new ProposalList(30, "ABC"),
            new ProposalList(90, "DEF"),
            new ProposalList(45, "GHI"),
            new ProposalList(30, "JKL"),
            new ProposalList(30, "MNO"),
            new ProposalList(90, "PQR"),
            new ProposalList(45, "STU"),
            new ProposalList(30, "VWX"),
            new ProposalList(30, "YZA"),
            new ProposalList(30, "MNO"),
            new ProposalList(90, "PQR"),
            new ProposalList(45, "STU"),
            new ProposalList(30, "VWX"),
            new ProposalList(30, "YZA"),
            new ProposalList(30, "ABC"),
            new ProposalList(90, "DEF"),
            new ProposalList(45, "GHI"),
            new ProposalList(30, "JKL"));
    FirstFitDecreasing fistFitDecreasingAlgo = new FirstFitDecreasing(proposalLists, 180);
    showTrackPermutations(fistFitDecreasingAlgo);
  }

  private static void getAllApprovedProposals() {
    System.out.println("****** Getting the proposal list *****");
    ProposalManagement proposalManagement = new ProposalManagement();
    proposalLists = proposalManagement.populateProposalList();
  }

  private static void showTrackPermutations(FirstFitDecreasing algo) {
    System.out.println("****** Showing the track permutations *****");
    TrackManagement trackManagement = new TrackManagement();
    trackManagement.showTrackList(algo);
  }
}
