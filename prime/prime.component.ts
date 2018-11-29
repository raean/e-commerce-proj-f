import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Global } from '../global';

@Component({
  selector: 'app-prime',
  templateUrl: './prime.component.html',
  styleUrls: ['./prime.component.css']
})
export class PrimeComponent implements OnInit {

  constructor(private http: HttpClient)
  { 
  this.showStat=false;
  }

  ngOnInit() {
  }

	  title= "Prime Calculator"
	  min;
	  max;
	  prev;
	  result;
	  status;
	  error;
	  findButt;
	nextButt;
	  showStat: boolean;
	showNext = true;
	  submitted= false;

  onSubmit(whatButton): void
  {    		
	if (whatButton === "Find") {
		this.submitted=true;
		let queryString= Global.PRIME_URL + "?min="+this.min+"&max="+this.max;
		this.http.get(queryString).subscribe(data =>
		{
		       	let resp = JSON.parse(JSON.stringify(data));
		       	this.status = resp.status;
		       	this.result = resp.data;
		       	if (this.status == false) {
			  	this.showStat = true;
		       		this.error = resp.data;
				this.prev = null;
				this.showNext= true;
		       	} else {
				this.showStat = false;
				this.prev = this.result;
				this.showNext= false;
	  		}
		});
	} else if (whatButton === "Next") {
		this.submitted=true;
		let queryString= Global.PRIME_URL + "?min="+this.prev+"&max="+this.max;
		this.http.get(queryString).subscribe(data =>
		{
			this.min = this.prev;
		       	let resp = JSON.parse(JSON.stringify(data));
		       	this.status = resp.status;
		       	this.result = resp.data;
		       	if (this.status == false) {
			  	this.showStat = true;
		       		this.error = resp.data;
				this.prev = null;
				this.showNext= true;
		       	} else {
				this.showStat = false;
				this.prev = this.result;
				this.showNext= false;
	  		}
		});
	}
  }
	

	

}

/* this.submitted=true;
		let queryString;
		if (this.prev == null) {
			this.prev = this.min;
			queryString= Global.PRIME_URL + "?min="+this.prev+"&max="+this.max;
	    	} else {
	    		queryString= Global.PRIME_URL + "?min="+this.prev+"&max="+this.max;
	    	}
	   
	    
	    	this.http.get(queryString).subscribe(data =>
		{

			this.min = this.prev;
		       	let resp = JSON.parse(JSON.stringify(data));
		       	this.status = resp.status;
		       	this.result = resp.data;
		       	if (this.status == false) {
			  	this.showStat = true;
		       		this.error = resp.data;
				this.prev = null;
		       	} else {
				this.showStat = false;
				this.prev = this.result;
	  		}
		}); */
