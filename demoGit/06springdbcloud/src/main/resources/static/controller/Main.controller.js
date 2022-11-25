//This is a class in UI5
//Class in UI5 is defined using special syntax as below(sap.ui.define)
//This is a Scaffolding Syntax where dependencies(other classes) are injected )
sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageBox",
	"sap/m/MessageToast",
	"dorimon/util/service"
], function(Controller, MessageBox, MessageToast, Service){
	return Controller.extend("dorimon.controller.Main", {
		
		onInit:function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"vendor": {
				        	"companyName": "EMC2",
					        "contactPerson": "TdT",
					        "firstName": "Srinivas",
					        "lastName": "AKY",
					        "website": "www.emc2.co.us",
					        "email": "srinivas.aky@emc2.com",
					        "status": "A",
					        "regDate": new Date()	
				},
				
				"vendorTab": []
			});
			this.getView().setModel(oModel);
			this.fetchAndLoadData();
		},
		fetchAndLoadData: function(){
			var oModel = this.getView().getModel();
			Service.callService("/vendor", "GET")
			.then(function(data){
				oModel.setProperty("/vendorTab", data);
				MessageToast.show(data.length.toString() + " Records were loaded");
			})
			.catch(function(){
				MessageBox.error("Error occured during vendor creation");
			});	
			
		},
		onSave: function() {
			var that = this;
			var oModel = this.getView().getModel();
			var payload = oModel.getProperty("/vendor");
			Service.callService("/vendor", "POST", payload)
			.then(function(){
				MessageBox.confirm("Record were saved");
				that.fetchAndLoadData().bind(that);
			})
			.catch(function(){
				MessageBox.error("Error occured during vendor creation");
			});
			
		}
	});
})