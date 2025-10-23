package de.wi25213.tests;

import org.junit.Assert;
import org.junit.Test;

import de.wi25213.uebung07.Course;

public class Uebung07_Course_Tests {

	public static String getFreeText(boolean isFree) {
		return isFree ? "Ja" : "Nein";
	}
	
	@Test
	public void testDisplayCourseInformation() {
		Course programmingCourse = new Course("Java Programmierung", true, 5);
		IO.println("=== Kurs 1: " + programmingCourse.getCourseName() + " ===");
		IO.println("Kostenlos: " + getFreeText(programmingCourse.isFree()));
		IO.println("Maximale Teilnehmer*innen: " + programmingCourse.getParticipantsNames().length);

		programmingCourse.addParticipant("Anna Schmidt");
		programmingCourse.addParticipant("Max Müller");
		programmingCourse.addParticipant("Lisa Weber");

		IO.println("Anzahl Teilnehmer*innen: " + programmingCourse.getParticipantCount());
		IO.println("Teilnehmer*innen:");
		for (int i = 0; i < programmingCourse.getParticipantCount(); i++) {
			IO.println("  " + (i + 1) + ". " + programmingCourse.getParticipantsNames()[i]);
		}
		IO.println();

		Course mathCourse = new Course("Höhere Mathematik", false, 3);
		IO.println("=== Kurs 2: " + mathCourse.getCourseName() + " ===");
		IO.println("Kostenlos: " + getFreeText(mathCourse.isFree()));
		IO.println("Maximale Teilnehmer*innen: " + mathCourse.getParticipantsNames().length);

		mathCourse.addParticipant("Tom Klein");
		mathCourse.addParticipant("Sarah Fischer");

		IO.println("Anzahl Teilnehmer*innen: " + mathCourse.getParticipantCount());
		IO.println("Teilnehmer*innen:");
		for (int i = 0; i < mathCourse.getParticipantCount(); i++) {
			IO.println("  " + (i + 1) + ". " + mathCourse.getParticipantsNames()[i]);
		}
		IO.println();
		
		Course englishCourse = new Course("Englisch für Anfänger", true, 10);
		IO.println("=== Kurs 3: " + englishCourse.getCourseName() + " ===");
		IO.println("Kostenlos: " + getFreeText(englishCourse.isFree()));
		IO.println("Maximale Teilnehmer*innen: " + englishCourse.getParticipantsNames().length);

		englishCourse.addParticipant("Peter Wagner");
		englishCourse.addParticipant("Maria Becker");
		englishCourse.addParticipant("Klaus Hoffmann");
		englishCourse.addParticipant("Julia Schneider");

		IO.println("Anzahl Teilnehmer*innen: " + englishCourse.getParticipantCount());
		IO.println("Teilnehmer*innen:");
		for (int i = 0; i < englishCourse.getParticipantCount(); i++) {
			IO.println("  " + (i + 1) + ". " + englishCourse.getParticipantsNames()[i]);
		}
		IO.println();
	}

	@Test
	public void testCourseNameGetter() {
		Course course = new Course("Java Programmierung", true, 5);
		Assert.assertEquals("Java Programmierung", course.getCourseName());
	}

	@Test
	public void testIsFreeGetter() {
		Course freeCourse = new Course("Kostenloser Kurs", true, 5);
		Course paidCourse = new Course("Kostenpflichtiger Kurs", false, 5);
		Assert.assertTrue(freeCourse.isFree());
		Assert.assertFalse(paidCourse.isFree());
	}

	@Test
	public void testAddParticipant() {
		Course course = new Course("Test Kurs", true, 5);
		Assert.assertEquals(0, course.getParticipantCount());

		course.addParticipant("Anna Schmidt");
		Assert.assertEquals(1, course.getParticipantCount());
		Assert.assertEquals("Anna Schmidt", course.getParticipantsNames()[0]);

		course.addParticipant("Max Müller");
		Assert.assertEquals(2, course.getParticipantCount());
		Assert.assertEquals("Max Müller", course.getParticipantsNames()[1]);
	}

	@Test
	public void testGetParticipantCount() {
		Course course = new Course("Test Kurs", true, 5);
		Assert.assertEquals(0, course.getParticipantCount());

		course.addParticipant("Teilnehmer*in 1");
		Assert.assertEquals(1, course.getParticipantCount());

		course.addParticipant("Teilnehmer*in 2");
		Assert.assertEquals(2, course.getParticipantCount());

		course.addParticipant("Teilnehmer*in 3");
		Assert.assertEquals(3, course.getParticipantCount());
	}

	@Test
	public void testGetParticipantsNames() {
		Course course = new Course("Test Kurs", true, 3);
		String[] participants = course.getParticipantsNames();
		Assert.assertNotNull(participants);
		Assert.assertEquals(3, participants.length);

		course.addParticipant("Anna");
		course.addParticipant("Max");
		Assert.assertEquals("Anna", course.getParticipantsNames()[0]);
		Assert.assertEquals("Max", course.getParticipantsNames()[1]);
	}

	@Test(expected = IllegalStateException.class)
	public void testAddParticipantToFullCourse() {
		Course smallCourse = new Course("Kleiner Kurs", true, 2);
		smallCourse.addParticipant("Teilnehmer*in 1");
		smallCourse.addParticipant("Teilnehmer*in 2");

		Assert.assertEquals(2, smallCourse.getParticipantCount());
		smallCourse.addParticipant("Teilnehmer*in 3");
	}

	@Test
	public void testEmptyCourse() {
		Course emptyCourse = new Course("Leerer Kurs", false, 5);

		Assert.assertEquals(0, emptyCourse.getParticipantCount());
		Assert.assertEquals("Leerer Kurs", emptyCourse.getCourseName());
		Assert.assertFalse(emptyCourse.isFree());
		Assert.assertEquals(5, emptyCourse.getParticipantsNames().length);
	}
}