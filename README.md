# ConferenceTrackManagementProject
ConferenceTrackManagementProject
##Problem Statement:
<pre>

You are planning a big programming conference and have received many proposals which have passed the initial screen process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities! So you write a program to do it for you. <br/>
	•	The conference has multiple tracks each of which has a morning and afternoon session. <br/>
	•	Each session contains multiple talks. <br/>
	•	Morning sessions begin at 9am and must finish by 12 noon, for lunch. <br/>
	•	Afternoon sessions begin at 1pm and must finish in time for the networking event. <br/>
	•	The networking event can start no earlier than 4:00 and no later than 5:00.<br/>
	•	No talk title has numbers in it.<br/>
	•	All talk lengths are either in minutes (not hours) or lightning (5 minutes).<br/>
	•	Presenters will be very punctual; there needs to be no gap between sessions.<br/>
 
Note that depending on how you choose to complete this problem, your solution may give a different ordering or combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here. <br/>
 
Test input:<br/>
Writing Fast Tests Against Enterprise Rails 60min<br/>
Overdoing it in Python 45min<br/>
Lua for the Masses 30min<br/>
Ruby Errors from Mismatched Gem Versions 45min<br/>
Common Ruby Errors 45min<br/>
Rails for Python Developers lightning<br/>
Communicating Over Distance 60min<br/>
Accounting-Driven Development 45min<br/>
Woah 30min<br/>
Sit Down and Write 30min<br/>
Pair Programming vs Noise 45min<br/>
Rails Magic 60min<br/>
Ruby on Rails: Why We Should Move On 60min<br/>
Clojure Ate Scala (on my project) 45min<br/>
Programming in the Boondocks of Seattle 30min<br/>
Ruby vs. Clojure for Back-End Development 30min<br/>
Ruby on Rails Legacy App Maintenance 60min<br/>
A World Without HackerNews 30min<br/>
User Interface CSS in Rails Apps 30min<br/>
 
Test output: <br/>
Track 1:<br/>
09:00AM Writing Fast Tests Against Enterprise Rails 60min<br/>
10:00AM Overdoing it in Python 45min<br/>
10:45AM Lua for the Masses 30min<br/>
11:15AM Ruby Errors from Mismatched Gem Versions 45min<br/>
12:00PM Lunch<br/>
01:00PM Ruby on Rails: Why We Should Move On 60min<br/>
02:00PM Common Ruby Errors 45min<br/>
02:45PM Pair Programming vs Noise 45min<br/>
03:30PM Programming in the Boondocks of Seattle 30min<br/>
04:00PM Ruby vs. Clojure for Back-End Development 30min<br/>
04:30PM User Interface CSS in Rails Apps 30min<br/>
05:00PM Networking Event<br/>
</pre>

Solution:<br/>
<pre>
Based on my rough work Captured below, I have used First Fit Decreasing Algorithm for this requirment. How it works ?<br/>

Step 1:<br/>
Sort teh items so that tehy are in decreasing order<br/>
Step 2: <br/>
Apply the first fit Algorithm to reordered list.<br/>

Example:<br/>
Given numbers:<br/>
8, 16, 12, 8, 45, 18, 30, 7, 10, 14, 9, 9, 52<br/>
Let's say Bin (in our case duration of track) size is 60 <br/>

Step 1: sorting in decreasing order<br/>
52, 45, 30, 18, 16,14, 12, 10, 9, 9, 8, 8, 7<br/>

Step 2: Bcketing (reordering)<br/>

          Bucket                      Remaining <br/>
1       52, 8                            60 (initial), 8 (after adding 52), 0 (after adding 8, other numbers not fit)<br/>
2.      45, 14                           60, 15, 1<br/>
3.      30, 18, 12                       60, 30, 12, 0<br/>
4.      16, 10, 9, 9, 8, 7               60, 44, 34, 25, 16, 8, 1<br/> 

total bucket required are 4.<br/>
</pre>

# Requirement Understanding (My Rough Work)<br/>

<pre>
Proposals (Many):<br/>
	Subject (arg [0]) - No number in it<br/>
	IsScreeningPass:<br/>
        Duration (in Minutes) (arg [1])<br/>
        
Actions:<br/>
      1. proposal store it in right data structure  (Collections, hash table / Map / Set):  should not take duplicates, no  ordering required<br/>
       2. sorting algorithm - required<br/>

Screening Process (Manual):<br/>

Time Constraint: <br/>

Conference:<br/>
  Tracks (Multiple)<br/>
	  Sessions<br/>
		Morning Session (9AM to 12 PM) = 180 min<br/>
		Evening Session (1 PM and 4PM) = 180 mins<br/>
		Networking Session (4 PM to 5 PM)<br/>

Problem Statement:<br/>
It is multiple combinations: <br/>
You need to find 2 sets of session with 180 min total, each session<br/>
if you have multiple tracks, don't consider the topics the you considered in the other track<br/>
Any Known Algorithm?? -  First Fit, Bin Packaging Problem (Bin Size = 180), for n bin output, apply nP2 permutation <br/>



</pre>
	 
