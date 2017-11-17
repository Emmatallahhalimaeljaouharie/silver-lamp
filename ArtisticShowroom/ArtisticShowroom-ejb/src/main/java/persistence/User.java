package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name = "`User`")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "AccessFailedCount")
	private int accessFailedCount;

	@Column(name = "AccountState")
	private boolean accountState;

	@Column(name = "AdminCode")
	private String adminCode;

	@Column(name = "Age")
	private int age;

	@Column(name = "ClientCode")
	private String clientCode;

	@Column(name = "Email")
	private String email;

	@Column(name = "EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name = "ExpertCode")
	private String expertCode;

	@Column(name = "Image")
	private String image;

	@Column(name = "IsClient")
	private int isClient;

	@Column(name = "LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name = "LockoutEndDateUtc")
	private Date lockoutEndDateUtc;

	@Column(name = "PasswordHash")
	private String passwordHash;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name = "SecurityStamp")
	private String securityStamp;

	@Column(name = "TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name = "UserName")
	private String userName;

	// bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy = "user")
	private List<Appointment> appointments;

	// bi-directional many-to-one association to Artwork
	@OneToMany(mappedBy = "user")
	private List<Artwork> artworks;

	// bi-directional many-to-one association to ArtworkSale
	@OneToMany(mappedBy = "user")
	private List<ArtworkSale> artworkSales;

	// bi-directional many-to-one association to BookingEquipment
	@OneToMany(mappedBy = "user")
	private List<BookingEquipment> bookingEquipments;

	// bi-directional many-to-one association to BookingGallery
	@OneToMany(mappedBy = "user")
	private List<BookingGallery> bookingGalleries;

	// bi-directional many-to-one association to ComplaintArtwork
	@OneToMany(mappedBy = "user")
	private List<ComplaintArtwork> complaintArtworks;

	// bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy = "user")
	private List<Equipment> equipments;

	// bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy = "user1")
	private List<Evaluation> evaluations1;

	// bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy = "user2")
	private List<Evaluation> evaluations2;

	// bi-directional many-to-one association to ExpositionEvent
	@OneToMany(mappedBy = "user")
	private List<ExpositionEvent> expositionEvents;

	// bi-directional many-to-one association to Gallery
	@OneToMany(mappedBy = "user")
	private List<Gallery> galleries;

	// bi-directional many-to-one association to ReservationStand
	@OneToMany(mappedBy = "user")
	private List<ReservationStand> reservationStands;

	// bi-directional many-to-one association to Training
	@OneToMany(mappedBy = "user")
	private List<Training> trainings;

	// bi-directional many-to-one association to TrainingParticipation
	@OneToMany(mappedBy = "user")
	private List<TrainingParticipation> trainingParticipations;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "AdministratorId")
	private User user1;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "user1")
	private List<User> users1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "AdministratorId1")
	private User user2;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "user2")
	private List<User> users2;

	// bi-directional many-to-one association to UserClaim
	@OneToMany(mappedBy = "user")
	private List<UserClaim> userClaims;

	// bi-directional many-to-one association to UserLogin
	@OneToMany(mappedBy = "user")
	private List<UserLogin> userLogins;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;

	// bi-directional many-to-many association to Role
	@ManyToMany(mappedBy = "users")
	private List<Role> roles;

	public User() {
	}

	public User(String id, int age, String email, int isClient, String passwordHash) {
		super();
		this.id = id;
		this.age = age;
		this.email = email;
		this.isClient = isClient;
		this.passwordHash = passwordHash;
	}

	public Date getLockoutEndDateUtc() {
		return lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getSecurityStamp() {
		return securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setExpertCode(String expertCode) {
		this.expertCode = expertCode;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public boolean getAccountState() {
		return this.accountState;
	}

	public void setAccountState(boolean accountState) {
		this.accountState = accountState;
	}

	public String getAdminCode() {
		return this.adminCode;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getExpertCode() {
		return this.expertCode;
	}

	public String getImage() {
		return this.image;
	}

	public int getIsClient() {
		return this.isClient;
	}

	public void setIsClient(int isClient) {
		this.isClient = isClient;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setUser(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setUser(null);

		return appointment;
	}

	public List<Artwork> getArtworks() {
		return this.artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	public Artwork addArtwork(Artwork artwork) {
		getArtworks().add(artwork);
		artwork.setUser(this);

		return artwork;
	}

	public Artwork removeArtwork(Artwork artwork) {
		getArtworks().remove(artwork);
		artwork.setUser(null);

		return artwork;
	}

	public List<ArtworkSale> getArtworkSales() {
		return this.artworkSales;
	}

	public void setArtworkSales(List<ArtworkSale> artworkSales) {
		this.artworkSales = artworkSales;
	}

	public ArtworkSale addArtworkSale(ArtworkSale artworkSale) {
		getArtworkSales().add(artworkSale);
		artworkSale.setUser(this);

		return artworkSale;
	}

	public ArtworkSale removeArtworkSale(ArtworkSale artworkSale) {
		getArtworkSales().remove(artworkSale);
		artworkSale.setUser(null);

		return artworkSale;
	}

	public List<BookingEquipment> getBookingEquipments() {
		return this.bookingEquipments;
	}

	public void setBookingEquipments(List<BookingEquipment> bookingEquipments) {
		this.bookingEquipments = bookingEquipments;
	}

	public BookingEquipment addBookingEquipment(BookingEquipment bookingEquipment) {
		getBookingEquipments().add(bookingEquipment);
		bookingEquipment.setUser(this);

		return bookingEquipment;
	}

	public BookingEquipment removeBookingEquipment(BookingEquipment bookingEquipment) {
		getBookingEquipments().remove(bookingEquipment);
		bookingEquipment.setUser(null);

		return bookingEquipment;
	}

	public List<BookingGallery> getBookingGalleries() {
		return this.bookingGalleries;
	}

	public void setBookingGalleries(List<BookingGallery> bookingGalleries) {
		this.bookingGalleries = bookingGalleries;
	}

	public BookingGallery addBookingGallery(BookingGallery bookingGallery) {
		getBookingGalleries().add(bookingGallery);
		bookingGallery.setUser(this);

		return bookingGallery;
	}

	public BookingGallery removeBookingGallery(BookingGallery bookingGallery) {
		getBookingGalleries().remove(bookingGallery);
		bookingGallery.setUser(null);

		return bookingGallery;
	}

	public List<ComplaintArtwork> getComplaintArtworks() {
		return this.complaintArtworks;
	}

	public void setComplaintArtworks(List<ComplaintArtwork> complaintArtworks) {
		this.complaintArtworks = complaintArtworks;
	}

	public ComplaintArtwork addComplaintArtwork(ComplaintArtwork complaintArtwork) {
		getComplaintArtworks().add(complaintArtwork);
		complaintArtwork.setUser(this);

		return complaintArtwork;
	}

	public ComplaintArtwork removeComplaintArtwork(ComplaintArtwork complaintArtwork) {
		getComplaintArtworks().remove(complaintArtwork);
		complaintArtwork.setUser(null);

		return complaintArtwork;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setUser(this);

		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setUser(null);

		return equipment;
	}

	public List<Evaluation> getEvaluations1() {
		return this.evaluations1;
	}

	public void setEvaluations1(List<Evaluation> evaluations1) {
		this.evaluations1 = evaluations1;
	}

	public Evaluation addEvaluations1(Evaluation evaluations1) {
		getEvaluations1().add(evaluations1);
		evaluations1.setUser1(this);

		return evaluations1;
	}

	public Evaluation removeEvaluations1(Evaluation evaluations1) {
		getEvaluations1().remove(evaluations1);
		evaluations1.setUser1(null);

		return evaluations1;
	}

	public List<Evaluation> getEvaluations2() {
		return this.evaluations2;
	}

	public void setEvaluations2(List<Evaluation> evaluations2) {
		this.evaluations2 = evaluations2;
	}

	public Evaluation addEvaluations2(Evaluation evaluations2) {
		getEvaluations2().add(evaluations2);
		evaluations2.setUser2(this);

		return evaluations2;
	}

	public Evaluation removeEvaluations2(Evaluation evaluations2) {
		getEvaluations2().remove(evaluations2);
		evaluations2.setUser2(null);

		return evaluations2;
	}

	public List<ExpositionEvent> getExpositionEvents() {
		return this.expositionEvents;
	}

	public void setExpositionEvents(List<ExpositionEvent> expositionEvents) {
		this.expositionEvents = expositionEvents;
	}

	public ExpositionEvent addExpositionEvent(ExpositionEvent expositionEvent) {
		getExpositionEvents().add(expositionEvent);
		expositionEvent.setUser(this);

		return expositionEvent;
	}

	public ExpositionEvent removeExpositionEvent(ExpositionEvent expositionEvent) {
		getExpositionEvents().remove(expositionEvent);
		expositionEvent.setUser(null);

		return expositionEvent;
	}

	public List<Gallery> getGalleries() {
		return this.galleries;
	}

	public void setGalleries(List<Gallery> galleries) {
		this.galleries = galleries;
	}

	public Gallery addGallery(Gallery gallery) {
		getGalleries().add(gallery);
		gallery.setUser(this);

		return gallery;
	}

	public Gallery removeGallery(Gallery gallery) {
		getGalleries().remove(gallery);
		gallery.setUser(null);

		return gallery;
	}

	public List<ReservationStand> getReservationStands() {
		return this.reservationStands;
	}

	public void setReservationStands(List<ReservationStand> reservationStands) {
		this.reservationStands = reservationStands;
	}

	public ReservationStand addReservationStand(ReservationStand reservationStand) {
		getReservationStands().add(reservationStand);
		reservationStand.setUser(this);

		return reservationStand;
	}

	public ReservationStand removeReservationStand(ReservationStand reservationStand) {
		getReservationStands().remove(reservationStand);
		reservationStand.setUser(null);

		return reservationStand;
	}

	public List<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Training addTraining(Training training) {
		getTrainings().add(training);
		training.setUser(this);

		return training;
	}

	public Training removeTraining(Training training) {
		getTrainings().remove(training);
		training.setUser(null);

		return training;
	}

	public List<TrainingParticipation> getTrainingParticipations() {
		return this.trainingParticipations;
	}

	public void setTrainingParticipations(List<TrainingParticipation> trainingParticipations) {
		this.trainingParticipations = trainingParticipations;
	}

	public TrainingParticipation addTrainingParticipation(TrainingParticipation trainingParticipation) {
		getTrainingParticipations().add(trainingParticipation);
		trainingParticipation.setUser(this);

		return trainingParticipation;
	}

	public TrainingParticipation removeTrainingParticipation(TrainingParticipation trainingParticipation) {
		getTrainingParticipations().remove(trainingParticipation);
		trainingParticipation.setUser(null);

		return trainingParticipation;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public User addUsers1(User users1) {
		getUsers1().add(users1);
		users1.setUser1(this);

		return users1;
	}

	public User removeUsers1(User users1) {
		getUsers1().remove(users1);
		users1.setUser1(null);

		return users1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public User addUsers2(User users2) {
		getUsers2().add(users2);
		users2.setUser2(this);

		return users2;
	}

	public User removeUsers2(User users2) {
		getUsers2().remove(users2);
		users2.setUser2(null);

		return users2;
	}

	public List<UserClaim> getUserClaims() {
		return this.userClaims;
	}

	public void setUserClaims(List<UserClaim> userClaims) {
		this.userClaims = userClaims;
	}

	public UserClaim addUserClaim(UserClaim userClaim) {
		getUserClaims().add(userClaim);
		userClaim.setUser(this);

		return userClaim;
	}

	public UserClaim removeUserClaim(UserClaim userClaim) {
		getUserClaims().remove(userClaim);
		userClaim.setUser(null);

		return userClaim;
	}

	public List<UserLogin> getUserLogins() {
		return this.userLogins;
	}

	public void setUserLogins(List<UserLogin> userLogins) {
		this.userLogins = userLogins;
	}

	public UserLogin addUserLogin(UserLogin userLogin) {
		getUserLogins().add(userLogin);
		userLogin.setUser(this);

		return userLogin;
	}

	public UserLogin removeUserLogin(UserLogin userLogin) {
		getUserLogins().remove(userLogin);
		userLogin.setUser(null);

		return userLogin;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}