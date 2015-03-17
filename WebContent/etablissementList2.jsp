<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h:form>

		<rich:panel>
			<rich:extendedDataTable height="150px" width="980" value="#{etablissementCtrl.etablissements}"
				var="b" id="table8" sortMode="single" selectionMode="single"
				selection="#{etablissementCtrl.selection}" binding="#{etablissementCtrl.table}">


				<rich:column sortable="true" sortBy="#{b.nom}"
					filterBy="#{b.nom}" filterEvent="onkeyup" width="80px"
					label="nom ">
					
			<f:facet name="header">
						<h:outputText value="Nom" />
					</f:facet>
					<h:outputText value="#{b.nom}" />
					
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.adresse}"
					 width="170px"
					label="adresse ">
					<f:facet name="header">
						<h:outputText value="adresse" />
					</f:facet>
					<h:outputText value="#{b.adresse}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.num_tel}"
					width="150px"
					label="numtel ">
					<f:facet name="header">
						<h:outputText value="numéro téléphone" />
					</f:facet>
					<h:outputText value="#{b.num_tel}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.num_fax}"
					width="80px"
					label="numfax ">
					<f:facet name="header">
						<h:outputText value="numéro fax" />
					</f:facet>
					<h:outputText value="#{b.num_fax}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.mot_cle}"
					 width="80px"
					label="mot_cle ">
					<f:facet name="header">
						<h:outputText value="mot clé" />
					</f:facet>
					<h:outputText value="#{b.mot_cle}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.emailetab}"
					 width="130px"
					label="email ">
					<f:facet name="header">
						<h:outputText value="Email" />
					</f:facet>
					<h:outputText value="#{b.email_etab}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.nom_respo}"
					 filterBy="#{b.nom_respo}" filterEvent="onkeyup" width="150px"
					label="respo ">
					<f:facet name="header">
						<h:outputText value="nom responsable" />
					</f:facet>
					<h:outputText value="#{b.nom_respo}" />
				</rich:column>
				<rich:column sortable="true" sortBy="#{b.nbretudiant}"
					 width="150px"
					label="nbretd ">
					<f:facet name="header">
						<h:outputText value="nombre étudiant" />
					</f:facet>
					<h:outputText value="#{b.nbr_etudiant}" />
				</rich:column>
				
				

				<a4j:support event="onselectionchange" reRender="restable"
					ajaxSingle="true" action="#{etablissementCtrl.takeSelection}"></a4j:support>
				

			</rich:extendedDataTable>
		</rich:panel>

		<rich:panel id="restable8" style="width:1020" >
			<f:facet name="header" >
				<h:outputText value="Etablissement selected"  />
			</f:facet>
			<rich:dataGrid columns="1" value="#{etablissementCtrl.selectedEtablissements}"
				var="cap" rendered="#{not empty etablissementCtrl.selectedEtablissements}">
				<h:outputText value="nom etab : " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.nom_etab}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="adresse etab: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.adresse_etab}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="num tel: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.num_tel}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="mot cle: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.mot_cle}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="num fax: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.num_fax}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="nom respo: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.nom_respo}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="email: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.email_etab}" />
				<div class="div_near_spacer"></div>
				<h:outputText value="nbr étudiant: " styleClass="label"></h:outputText>
				<h:outputText value="#{cap.nbr_etudiant}" />
				<div class="div_near_spacer"></div>
				
				<h:commandButton value="Modifier" type="submit"
	 				action="#{etablissementCtrl.editerEtablissement}" /> 
				
				<h:commandButton value="supprimer" type="submit"
	 				action="#{etablissementCtrl.deleteEtablissement}" />

			</rich:dataGrid>
			
</rich:panel>
</h:form>
</body>
</html>
</f:view>