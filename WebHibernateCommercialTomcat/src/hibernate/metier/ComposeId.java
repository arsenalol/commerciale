package hibernate.metier;

// Generated 12 avr. 2013 15:49:55 by Hibernate Tools 4.0.0

/**
 * ComposeId generated by hbm2java
 */
public class ComposeId implements java.io.Serializable {

	private String noCompose;
	private String noComposant;

	public ComposeId() {
	}

	public ComposeId(String noCompose, String noComposant) {
		this.noCompose = noCompose;
		this.noComposant = noComposant;
	}

	public String getNoCompose() {
		return this.noCompose;
	}

	public void setNoCompose(String noCompose) {
		this.noCompose = noCompose;
	}

	public String getNoComposant() {
		return this.noComposant;
	}

	public void setNoComposant(String noComposant) {
		this.noComposant = noComposant;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComposeId))
			return false;
		ComposeId castOther = (ComposeId) other;

		return ((this.getNoCompose() == castOther.getNoCompose()) || (this
				.getNoCompose() != null && castOther.getNoCompose() != null && this
				.getNoCompose().equals(castOther.getNoCompose())))
				&& ((this.getNoComposant() == castOther.getNoComposant()) || (this
						.getNoComposant() != null
						&& castOther.getNoComposant() != null && this
						.getNoComposant().equals(castOther.getNoComposant())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNoCompose() == null ? 0 : this.getNoCompose().hashCode());
		result = 37
				* result
				+ (getNoComposant() == null ? 0 : this.getNoComposant()
						.hashCode());
		return result;
	}

}
