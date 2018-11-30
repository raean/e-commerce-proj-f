package model;

import java.util.List;

public class Table
{
	
	public String status;
	
	public List<StudentBean> data;
	
	public Table() {
		this.status = "true";
	}
	
	public Table(List<StudentBean> beans) {
		this.status = "true";
		this.data = beans;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public List<StudentBean> getBeans()
	{
		return data;
	}

	public void setBeans(List<StudentBean> beans)
	{
		this.data = beans;
	}
	
	
	
}
