package com.conference.algorithm;

import com.conference.track.ProposalList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstFitDecreasing {

  private List<Track> bins = new ArrayList<Track>();

  protected List<ProposalList> in;
  protected int binSize;

  public FirstFitDecreasing(List<ProposalList> in, int binSize) {
    this.in = in;
    this.binSize = binSize;
  }

  public int getResult() {
    Collections.sort(in, Collections.reverseOrder()); // sort input by size (big to small)
    bins.add(new Track(binSize)); // add first bin
    for (ProposalList currentItem : in) {
      // iterate over bins and try to put the item into the first one it fits into
      boolean putItem = false; // did we put the item in a bin?
      int currentBin = 0;
      while (!putItem) {
        if (currentBin == bins.size()) {
          // item did not fit in last bin. put it in a new bin
          Track newBin = new Track(binSize);
          newBin.put(currentItem);
          bins.add(newBin);
          putItem = true;
        } else if (bins.get(currentBin).put(currentItem)) {
          // item fit in bin
          putItem = true;
        } else {
          // try next bin
          currentBin++;
        }
      }
    }
    return bins.size();
  }

  public void printBestBins() {
    System.out.println("Tracks:");
    if (bins.size() == in.size()) {
      System.out.println("each proposal is in its own track");
    } else {
      int num = 0;
      int flag = 1;
      for (Track bin : bins) {

        System.out.println("*** Conference Track " + ((num / 2) % 10) + " started ***");
        int i = 0;
        while (i < bin.getItems().size() && null != bin.getItems().get(i)) {
          System.out.print(
              bin.getItems().get(i).getDuration()
                  + " Minutes session for "
                  + bin.getItems().get(i).getTitle()
                  + "\n");
          i++;
        }
        if (i == 0 || (i % 2) != 0) System.out.println("*** Lunch Break ***");
        if (i == 1 || (i % 2) == 0) {
          System.out.println("*** Networking Event ***");
          flag = 1;
        }
        num++;
        flag++;
      }
    }
  }

  public List<Track> deepCopy(List<Track> bins) {
    ArrayList<Track> copy = new ArrayList<Track>();
    for (int i = 0; i < bins.size(); i++) {
      copy.add(bins.get(i).deepCopy());
    }
    return copy;
  }
}
