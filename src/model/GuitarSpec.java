package model;

public class GuitarSpec {
		public String builder;
		public String model;
		public String type;
		public String backWood;
		public String topWood;
		public int numStrings;

		public GuitarSpec(String builder, String model, String type, int numStrings, String backWood, String topWood) {
			this.builder = builder;
			this.model = model;
			this.type = type;
			this.numStrings = numStrings;
			this.backWood = backWood;
			this.topWood = topWood;
		}

		public String getBuilder() {
			return builder;
		}

		public void setBuilder(String builder) {
			this.builder = builder;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBackWood() {
			return backWood;
		}

		public void setBackWood(String backWood) {
			this.backWood = backWood;
		}

		public String getTopWood() {
			return topWood;
		}

		public void setTopWood(String topWood) {
			this.topWood = topWood;
		}

		public int getnumStrings() {
			return numStrings;
		}

		public void setnumStrings(int numStrings) {
			this.numStrings = numStrings;
		}

		public boolean isMatched(GuitarSpec spec){
			if(builder!=spec.getBuilder()){
				return false;
			}else if(type!=spec.getType()){
				return false;
			}else if(backWood!=spec.getBackWood()){
				return false;
			}else if(topWood!=spec.getTopWood()){
				return false;
			}else if(numStrings!=spec.getnumStrings()){
				return false;
			}else if((model!=null)&&(!model.equals(""))&&(!model.toUpperCase().equals(spec.getModel().toUpperCase()))){
				return false;
			}else{
				return true;
			}
		}
	}
