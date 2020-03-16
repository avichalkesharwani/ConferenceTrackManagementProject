package com.conference.algorithm;

import com.conference.track.ProposalList;

import java.util.ArrayList;
import java.util.List;

/**
 * A Bin holding integers. The number of items it can hold is not limited, but the added value of
 * the items it holds may not be higher than the given maximal size.
 */
public class Track {

  /** maximal allowed added value of items. */
  protected int maxSize;
  /** current added value of items. */
  protected int currentSize;
  /** list of items in bin. */
  protected List<ProposalList> items;

  // protected String topic;

  /**
   * construct new bin with given maximal size.
   *
   * @param maxSize
   */
  public Track(int maxSize) {
    this.maxSize = maxSize;
    this.currentSize = 0;
    this.items = new ArrayList<ProposalList>();
  }

  public boolean put(ProposalList item) {
    if (currentSize + item.getDuration() <= maxSize) {
      items.add(item);
      currentSize += item.getDuration();
      return true;
    } else {
      return false; // item didn't fit
    }
  }

  public void remove(ProposalList item) {
    items.remove(item.getDuration());
    currentSize -= item.getDuration();
  }

  public int numberOfItems() {
    return items.size();
  }

  public Track deepCopy() {
    Track copy = new Track(0);
    copy.items = new ArrayList<ProposalList>(items); // Integers are not copied by reference
    copy.currentSize = currentSize;
    copy.maxSize = maxSize;
    return copy;
  }

  @Override
  public String toString() {
    String res = "";
    for (int i = 0; i < items.size(); i++) {
      res += items.get(i) + " ";
    }
    res += "    Size: " + currentSize + " (max: " + maxSize + ")";
    return res;
  }

  public List<ProposalList> getItems() {
    return items;
  }
}
