package com.opencodez;

public class Iris {

	private Double sepalLength;
	private Double sepalWidth;
	private Double petalLength;
	private Double petalWidth;

	private String irisClass;

	public Iris(Double sl, Double sw, Double pl, Double pw) {
		sepalLength = sl;
		sepalWidth = sw;
		petalLength = pl;
		petalWidth = pw;
	}

	public Double getSepalLength() {
		return sepalLength;
	}

	public void setSepalLength(Double sepalLength) {
		this.sepalLength = sepalLength;
	}

	public Double getSepalWidth() {
		return sepalWidth;
	}

	public void setSepalWidth(Double sepalWidth) {
		this.sepalWidth = sepalWidth;
	}

	public Double getPetalLength() {
		return petalLength;
	}

	public void setPetalLength(Double petalLength) {
		this.petalLength = petalLength;
	}

	public Double getPetalWidth() {
		return petalWidth;
	}

	public void setPetalWidth(Double petalWidth) {
		this.petalWidth = petalWidth;
	}

	public String getIrisClass() {
		return irisClass;
	}

	public void setIrisClass(String irisClass) {
		this.irisClass = irisClass;
	}

	@Override
	public String toString() {
		return String.format(
				"Iris Class = %s, Data[ Sepal Length = %.1f, Sepal Width = %.1f, Petal Length = %.1f, Petal Width = %.1f ]",
				irisClass, sepalLength, sepalWidth, petalLength, petalWidth);
	}

}
