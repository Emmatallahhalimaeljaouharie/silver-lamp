package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Evaluation database table.
 * 
 */
@Entity
@NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EvaluationPK id;

	@Column(name = "EvaluationMention")
	private int evaluationMention;

	@Column(name = "EvaluationNote")
	private String evaluationNote;

	// bi-directional many-to-one association to Artwork
	@ManyToOne
	@JoinColumn(name = "ArtworkFk", referencedColumnName = "ArtworkId", insertable = false, updatable = false)
	private Artwork artwork;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "ExpertFk", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "Expert_Id")
	private User user2;

	public Evaluation() {
	}

	public EvaluationPK getId() {
		return this.id;
	}

	public void setId(EvaluationPK id) {
		this.id = id;
	}

	public int getEvaluationMention() {
		return this.evaluationMention;
	}

	public void setEvaluationMention(int evaluationMention) {
		this.evaluationMention = evaluationMention;
	}

	public Object getEvaluationNote() {
		return this.evaluationNote;
	}

	public void setEvaluationNote(Object evaluationNote) {
		this.evaluationNote = (String) evaluationNote;
	}

	public Artwork getArtwork() {
		return this.artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}