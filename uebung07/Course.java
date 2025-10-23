package de.wi25213.uebung07;

//Aufgabe 5
public class Course {
	private String _courseName;
	private boolean _isFree;
	private String[] _participantsNames;
	private int _participantCount;
	
	public Course(String courseName, boolean isFree, int maxParticipants) {
		_courseName = courseName;
		_isFree = isFree;
		_participantsNames = new String[maxParticipants];
		_participantCount = 0;
	}
	
	public String getCourseName() {
		return _courseName;
	}
	
	public boolean isFree() {
		return _isFree;
	}
	
	public String[] getParticipantsNames() {
		return _participantsNames;
	}
	
	public int getParticipantCount() {
		return _participantCount;
	}
	
	public void addParticipant(String participantName) {
	        if (_participantCount < _participantsNames.length) {
	            _participantsNames[_participantCount] = participantName;
	            _participantCount++;
	        } else {
	            throw new IllegalStateException("Maximum number of participants reached.");
	        }
	    }
	 
	 
	
}