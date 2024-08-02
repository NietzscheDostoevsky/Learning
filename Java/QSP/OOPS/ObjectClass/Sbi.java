class Sbi {
	String name; 

	Sbi(String name) {
		this.name = name; 
	}

	@Override
	public boolean equals (Object obj) {
		Sbi s = (Sbi) obj; 
		return this.name == s.name; 
	}
}