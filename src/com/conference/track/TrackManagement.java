package com.conference.track;


import com.conference.algorithm.FirstFitDecreasing;

public class TrackManagement {
    public void showTrackList(FirstFitDecreasing algo) {
        System.out.println( algo.getResult());
        algo.printBestBins();
    }
}
