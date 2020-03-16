package com.conference.track;

public class ProposalList implements Comparable<ProposalList> {

  int duration;
  String title;

  public ProposalList(int duration, String title) {
    this.duration = duration;
    this.title = title;
  }

  public int getDuration() {
    return duration;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public int compareTo(ProposalList o) {
    return this.duration;
  }
}
