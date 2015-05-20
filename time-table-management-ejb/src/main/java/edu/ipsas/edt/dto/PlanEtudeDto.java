package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class PlanEtudeDto implements Serializable {

	private static final long serialVersionUID = 1L;


		private long planEtudeId;
		
		private SemestreDto semestreDto;
		
		private ParcoursDto parcoursDto;
		
		private Collection<MatiereDto> matieresDto;
		
		public PlanEtudeDto() {
			matieresDto = new ArrayList<MatiereDto>();
		}

		public long getPlanEtudeId() {
			return planEtudeId;
		}

		public void setPlanEtudeId(long planEtudeId) {
			this.planEtudeId = planEtudeId;
		}

		public SemestreDto getSemestreDto() {
			return semestreDto;
		}

		public void setSemestreDto(SemestreDto semestreDto) {
			this.semestreDto = semestreDto;
		}

		public ParcoursDto getParcoursDto() {
			return parcoursDto;
		}

		public void setParcoursDto(ParcoursDto parcoursDto) {
			this.parcoursDto = parcoursDto;
		}

		public Collection<MatiereDto> getMatieresDto() {
			return matieresDto;
		}

		public void setMatieresDto(Collection<MatiereDto> matieres) {
			this.matieresDto = matieres;
		}

	

}
