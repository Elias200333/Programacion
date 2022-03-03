package aviones;

public class Accidentes {
	private String date = "nulo";
	private String time = "nulo";
	private String location = "nulo";
	private String operator = "nulo";
	private int nFlight = 0;
	private String route = "nulo";
	private String type = "nulo";
	private String registration = "nulo";
	private String cnIn = "nulo";
	private int aboard = 0;
	private int fatalities = 0;
	private boolean ground = false;
	private String sumary;
	
	public Accidentes(
			String date, String time, String location, 
			String operator, String nFlight, String route, 
			String type, String registration, String cnIn, 
			String aboard, String fatalities, String ground, 
			String sumary) 
	{
		if (noEsNulo(date)) {
			this.date = date.replaceAll("\"", "");
		}
		if (noEsNulo(time)) {
			this.time = time.replaceAll("\"", "");
		}
		if (noEsNulo(location)) {
			this.location = location.replaceAll("\"", "");
		}
		if (noEsNulo(operator)) {
			this.operator = operator.replaceAll("\"", "");
		}
		if (noEsNulo(nFlight)) {
			try {
				this.nFlight = Integer.parseInt(nFlight);
			}catch(Exception e){}
		}
		if (noEsNulo(route)) {
			this.route = route.replaceAll("\"", "");
		}
		if (noEsNulo(type)) {
			this.type = type.replaceAll("\"", "");
		}
		if (noEsNulo(registration)) {
			this.registration = registration.replaceAll("\"", "");
		}
		if (noEsNulo(cnIn)) {
			this.cnIn = cnIn.replaceAll("\"", "");
		}
		if (noEsNulo(aboard)) {
			try {
				this.aboard = Integer.parseInt(aboard);
			}catch(Exception e){}
		}
		if (noEsNulo(fatalities)) {
			try {
				this.fatalities = Integer.parseInt(fatalities);
			}catch(Exception e){}
			
		}
		if (noEsNulo(ground)) {
			if (ground.contains("1")) {
				this.ground = true;
			} else {
				this.ground = false;
			}
		}
		if (noEsNulo(sumary)) {
			this.sumary = sumary.replaceAll("\"", "");;
		}
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getnFlight() {
		return nFlight;
	}

	public void setnFlight(int nFlight) {
		this.nFlight = nFlight;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getCnIn() {
		return cnIn;
	}

	public void setCnIn(String cnIn) {
		this.cnIn = cnIn;
	}

	public int getAboard() {
		return aboard;
	}

	public void setAboard(int aboard) {
		this.aboard = aboard;
	}

	public int getFatalities() {
		return fatalities;
	}

	public void setFatalities(int fatalities) {
		this.fatalities = fatalities;
	}

	public boolean isGround() {
		return ground;
	}

	public void setGround(boolean ground) {
		this.ground = ground;
	}

	public String getSumary() {
		return sumary;
	}

	public void setSumary(String sumary) {
		this.sumary = sumary;
	}

	private boolean noEsNulo(String dato) {
		if(dato.length() == 0||dato == null) {
			return false;
		}
		return true;
	}
}
