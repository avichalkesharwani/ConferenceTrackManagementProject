# ConferenceTrackManagementProject
ConferenceTrackManagementProject \n
Problem Statement:

You are planning a big programming conference and have received many proposals which have passed the initial screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! So you write a program to do it for you.
	•	The conference has multiple tracks each of which has a morning and afternoon session.
	•	Each session contains multiple talks.
	•	Morning sessions begin at 9am and must finish by 12 noon, for lunch.
	•	Afternoon sessions begin at 1pm and must finish in time for the networking event.
	•	The networking event can start no earlier than 4:00 and no later than 5:00.
	•	No talk title has numbers in it.
	•	All talk lengths are either in minutes (not hours) or lightning (5 minutes).
	•	Presenters will be very punctual; there needs to be no gap between sessions.
 
Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here.
 
Test input:
Writing Fast Tests Against Enterprise Rails 60min
Overdoing it in Python 45min
Lua for the Masses 30min
Ruby Errors from Mismatched Gem Versions 45min
Common Ruby Errors 45min
Rails for Python Developers lightning
Communicating Over Distance 60min
Accounting-Driven Development 45min
Woah 30min
Sit Down and Write 30min
Pair Programming vs Noise 45min
Rails Magic 60min
Ruby on Rails: Why We Should Move On 60min
Clojure Ate Scala (on my project) 45min
Programming in the Boondocks of Seattle 30min
Ruby vs. Clojure for Back-End Development 30min
Ruby on Rails Legacy App Maintenance 60min
A World Without HackerNews 30min
User Interface CSS in Rails Apps 30min
 
Test output: 
Track 1:
09:00AM Writing Fast Tests Against Enterprise Rails 60min
10:00AM Overdoing it in Python 45min
10:45AM Lua for the Masses 30min
11:15AM Ruby Errors from Mismatched Gem Versions 45min
12:00PM Lunch
01:00PM Ruby on Rails: Why We Should Move On 60min
02:00PM Common Ruby Errors 45min
02:45PM Pair Programming vs Noise 45min
03:30PM Programming in the Boondocks of Seattle 30min
04:00PM Ruby vs. Clojure for Back-End Development 30min
04:30PM User Interface CSS in Rails Apps 30min
05:00PM Networking Event


Solution:

Based on my rough work Captured below, I have used First Fit Decreasing Algorithm for this requirment. How it works ?

Step 1:
Sort teh items so that tehy are in decreasing order
Step 2: 
Apply the first fit Algorithm to reordered list.

Example:
Given numbers:
8, 16, 12, 8, 45, 18, 30, 7, 10, 14, 9, 9, 52
Let's say Bin (in our case duration of track) size is 60 

Step 1: sorting in decreasing order
52, 45, 30, 18, 16,14, 12, 10, 9, 9, 8, 8, 7

Step 2: Bcketing (reordering)
          Bucket                      Remaining
1       52, 8                            60 (initial), 8 (after adding 52), 0 (after adding 8, other numbers not fit)
2.      45, 14                           60, 15, 1
3.      30, 18, 12                       60, 30, 12, 0
4.      16, 10, 9, 9, 8, 7               60, 44, 34, 25, 16, 8, 1 

total bucket required are 4.


Requirement Understanding (My Rough Work)


https://github.com/vinodborole/BrainTeasers/blob/master/src/com/vinodborole/brainteasers/ctm/algo/BinPackingFirstFitDecreasing.java

Proposals (Many):
	Subject (arg [0]) - No number in it
	IsScreeningPass:
        Duration (in Minutes) (arg [1])
        
Actions:
      1. proposal store it in right data structure  (Collections, hash table / Map / Set):  should not take duplicates, no ordering required
       2. sorting algorithm - required

Screening Process (Manual):

Time Constraint: 

Conference:
  Tracks (Multiple)
	  Sessions
		Morning Session (9AM to 12 PM) = 180 min
		Evening Session (1 PM and 4PM) = 180 mins
		Networking Session (4 PM to 5 PM)

Problem Statement:
It is multiple combinations: 
You need to find 2 sets of session with 180 min total, each session
if you have multiple tracks, don't consider the topics the you considered in the other track
Any Known Algorithm?? -  First Fit, Bin Packaging Problem (Bin Size = 180), for n bin output, apply nP2 permutation 

Possible Data Modelling for Output  


	 
