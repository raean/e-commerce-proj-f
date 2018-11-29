import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Global } from '../global';


@Component({
  selector: 'app-sis',
  templateUrl: './sis.component.html',
  styleUrls: ['./sis.component.css']
})
export class SisComponent implements OnInit {

  constructor(private http: HttpClient)
  { this.showStat=false; }

  ngOnInit() {
  }
 
  title= "Sis Calculator"
  prefix;
  minGPA;
  sortBy;
  result;
  status;
  showStat: boolean;
  submitted=false;

  
onSubmit(): void
  {  

	this.submitted=true;
	alert(this.sortBy);
	if(this.prefix === undefined)
	{ 
	this.prefix = "";

	let queryString= Global.SIS_URL + "?prefix="+this.prefix+"&minGPA="+this.minGPA+"&sortBy="+this.sortBy;
	}

	if(this.minGPA === undefined)
	{
	this.minGPA = "";

	let queryString= Global.SIS_URL + "?prefix="+this.prefix+"&minGPA="+this.minGPA+"&sortBy="+this.sortBy;

	}

	

	
	let queryString= Global.SIS_URL + "?prefix="+this.prefix+"&minGPA="+this.minGPA+"&sortBy="+this.sortBy;

		this.http.get(queryString).subscribe(data =>
		{
		       	let resp = JSON.parse(JSON.stringify(data));

               		this.status = resp.status;
			this.result = resp.data;
			if (this.status == false) {
			  	this.showStat = true;
		       		this.result = resp.data;
		       	} else {
				this.showStat = false;
				this.result = resp.data;
	  		}
		});

}

}
