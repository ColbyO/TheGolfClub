package com.backend.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.backend.models.*;
import com.backend.repositories.*;
import com.backend.controller.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BackendApplicationTests {
	Tournaments tournaments;
	Membership membership;
	public List<Tournaments> mockTournaments;
	public List<CurrentTournament> mockCurrentTournaments;
	public List<PastTournament> mockPastTournaments;
	public List<UpcomingTournament> mockUpcomingTournaments;

	@MockBean
	private MembersRepository membersRepository;
	private MembershipRepository membershipRepository;
	private MembershipTypeRepository membershipTypeRepository;
	private TournamentRepository tournamentRepository;
	private CurrentTournamentRepository currentTournamentsRepository;
	private PastTournamentRepository pastTournamentsRepository;
	private UpcomingTournamentRepository upcomingTournamentsRepository;

	@Autowired
	private TournamentController mockTournamentController = Mockito.mock(TournamentController.class);
	private CurrentTournament mockCurrentTournamentController = Mockito.mock(CurrentTournament.class);
	private PastTournament mockPastTournamentController = Mockito.mock(PastTournament.class);
	private UpcomingTournament mockUpcomingTournamentController = Mockito.mock(UpcomingTournament.class);
	private MembershipController mockMembershipController = Mockito.mock(MembershipController.class);
	private MembershipTypeController mockMembershipTypeController = Mockito.mock(MembershipTypeController.class);
	private MembersController mockMembersController = Mockito.mock(MembersController.class);

	@Test
	public void testMembership() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockMembership).when(mockMembershipController.createMembership(mockMembership));

		// mockMembershipController.createMembership(mockMembership);
		// verify(mockMembershipController, times(1)).createMembership(mockMembership);
		verify(mockMembershipController, times(1)).getAllMembers(LocalDate.now());
	}

	@Test
	public void testMembers() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockMembers).when(mockMembersController.createMember(mockMembers));
		assertEquals("John", mockMembers);
		verify(mockMembersController, times(1)).getMembersById(1);
	}

	@Test
	public void testMembershipType() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockMembershipType).when(mockMembershipTypeController.createMembershipType(mockMembershipType));
		assertEquals(1, mockMembershipType.getId());
		verify(mockMembershipTypeController, times(1)).getMembershipTypesById(1);
	}

	@Test
	public void testTournament() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockTournament).when(mockTournamentController.postTournament(mockTournament));
		assertEquals(2, mockTournament.getId());
		verify(mockTournamentController, times(1)).getAllTournamentsByTime("12/5/2020", "1/5/2021");
	}

	@Test
	public void testCurrentTournament() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockCurrentTournament.getCurrentTournamentId()).when(mockCurrentTournamentController.getCurrentTournamentId());
		assertEquals(1, mockCurrentTournament.getCurrentTournamentId());
		verify(mockCurrentTournamentController, times(1)).getCurrentTournamentId();
	}

	@Test
	public void testPastTournament() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockPastTournament.getPastTournamentId()).when(mockPastTournamentController.getPastTournamentId());
		assertEquals(1, mockPastTournament.getPastTournamentId());
		verify(mockPastTournamentController, times(1)).getPastTournamentId();
	}

	@Test
	public void testUpcomingTournament() {
		Membership mockMembership = new Membership();
		mockMembership.setId(1);
		mockMembership.setDuration(LocalTime.now());
		mockMembership.setStartDate(LocalDate.now());
		MembershipType mockMembershipType = new MembershipType(1, "plan", "type");
		mockMembership.setMembershipType(mockMembershipType);
		Members mockMembers = new Members();
		mockMembers.setId(1);
		mockMembers.setFirstName("John");
		mockMembers.setLastName("Doe");
		mockMembers.setEmail("test@gmail.com");
		mockMembers.setAddress("123 Street");
		Tournaments mockTournament = new Tournaments(2, "12/5/2020", "1/5/2021", 15.00, 20.00, "Jane Doe", "2");
		mockTournaments.add(mockTournament);
		CurrentTournament mockCurrentTournament = new CurrentTournament(1, LocalDate.now(), mockTournaments);
		PastTournament mockPastTournament = new PastTournament(1, LocalDate.now(), mockTournaments);
		UpcomingTournament mockUpcomingTournament = new UpcomingTournament(1, LocalDate.now(), mockTournaments);
		mockCurrentTournaments.add(mockCurrentTournament);
		mockPastTournaments.add(mockPastTournament);
		mockUpcomingTournaments.add(mockUpcomingTournament);
		mockMembers.setCurrentTournaments(mockCurrentTournaments);
		mockMembers.setPastTournaments(mockPastTournaments);
		mockMembers.setUpcomingTournaments(mockUpcomingTournaments);
		mockMembership.setMember(mockMembers);

		Mockito.doReturn(mockUpcomingTournament.getUpcomingTournamentId()).when(mockUpcomingTournamentController.getUpcomingTournamentId());
		assertEquals(1, mockUpcomingTournament.getUpcomingTournamentId());
		verify(mockUpcomingTournamentController, times(1)).getUpcomingTournamentId();
	}

}
