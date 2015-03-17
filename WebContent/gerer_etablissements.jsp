<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
	<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
	<html>
	<head>
	<style>
.label {
	font-weight: bold;
}

.pbody {
	width: 200px;
}

.div_near_spacer {
	border-top-width: 0px;
	border-left-width: 0px;
	font-size: 0px;
	border-bottom-width: 0px;
	height: 2px;
	border-right-width: 0px
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>Gérer les établissements</title>

	</head>
	<body>
	<h2 align="center">Gérer les établissements</h2>

	<rich:tabPanel>
		<rich:tab label="Ajouter établissement">

			<rich:panel>
				<f:facet name="header">
					<h:outputText value="Ajouter établissement"></h:outputText>
				</f:facet>

				<h:panelGrid>
					<h:form>
						<rich:layout>
							<rich:layoutPanel position="left">
								<h:panelGrid>

									<h:outputText value="Nom de l'établissement:" />
									<h:inputText id="nom"
										value="#{etablissementCtrl.newEtablissement.nom_etab}"
										required="false" />

									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValNOM}"></h:outputLabel>
									<h:outputText />
									<div class="div_near_spacer"></div>

									<h:outputText value="Adresse de l'établissement:" />
									<h:inputText id="adresse"
										value="#{etablissementCtrl.newEtablissement.adresse_etab}"
										required="false" />
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValAdresse}"></h:outputLabel>
									<h:outputText />
									<div class="div_near_spacer"></div>

									<h:outputText value="Numéro de téléphone de l'établissement:" />
									<h:inputText id="numtel"
										value="#{etablissementCtrl.newEtablissement.num_tel}"
										required="false" />
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValNum_tel}"></h:outputLabel>
									<h:outputText />
									<div class="div_near_spacer"></div>

								</h:panelGrid>
							</rich:layoutPanel>
							<rich:layoutPanel position="center">
								<h:panelGrid>

									<h:outputText value="Numéro de fax de l'établissement:" />
									<h:inputText id="numfax"
										value="#{etablissementCtrl.newEtablissement.num_fax}"
										required="false">

									</h:inputText>
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValNum_fax}"></h:outputLabel>

									<h:outputText />
									<div class="div_near_spacer"></div>

									<h:outputText value="Mot clé de l'établissement:" />
									<h:inputText id="motcle"
										value="#{etablissementCtrl.newEtablissement.mot_cle}"
										required="false">

									</h:inputText>
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValMot_cle}"></h:outputLabel>

									<h:outputText />
									<div class="div_near_spacer"></div>

									<h:outputText value="Email de l'établissement :" />
									<h:inputText id="email"
										value="#{etablissementCtrl.newEtablissement.email_etab}"
										required="false">

									</h:inputText>
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValEmail}"></h:outputLabel>

									<h:outputText />
									<div class="div_near_spacer"></div>


								</h:panelGrid>
							</rich:layoutPanel>


							<rich:layoutPanel position="right">

								<h:panelGrid>
									<h:outputText value="Nom du responsable de l'établissement:" />
									<h:inputText id="nomrespo"
										value="#{etablissementCtrl.newEtablissement.nom_respo}"
										required="false">

									</h:inputText>
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValNomRespo}"></h:outputLabel>

									<h:outputText />
									<div class="div_near_spacer"></div>
									<h:outputText value="Nombre des étudiants de l'établissement :" />
									<h:inputText id="nbretudiant"
										value="#{etablissementCtrl.newEtablissement.nbr_etudiant}"
										required="false">

									</h:inputText>
									<h:outputLabel
										style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
										value="#{etablissementCtrl.messageValNbr_etudiant}"></h:outputLabel>

									<h:outputText />
									<div class="div_near_spacer"></div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		  <h:commandButton value="Ajouter"
										action="#{etablissementCtrl.createEtablissement}" />


								</h:panelGrid>
							</rich:layoutPanel>



						</rich:layout>
					</h:form>
				</h:panelGrid>

			</rich:panel>
		</rich:tab>
		<rich:tab label="Lister établissements">
			<h:form>

				<rich:panel>
					<rich:extendedDataTable height="150px" width="990"
						value="#{etablissementCtrl.etablissements}" var="b" id="table8"
						sortMode="single" selectionMode="single"
						selection="#{etablissementCtrl.selection}"
						binding="#{etablissementCtrl.table}">


						<rich:column sortable="true" sortBy="#{b.nom}" filterBy="#{b.nom}"
							filterEvent="onkeyup" width="80px" label="nom ">

							<f:facet name="header">
								<h:outputText value="Nom" />
							</f:facet>
							<h:outputText value="#{b.nom}" />

						</rich:column>
						<rich:column sortable="true" sortBy="#{b.adresse}" width="170px"
							label="adresse ">
							<f:facet name="header">
								<h:outputText value="adresse" />
							</f:facet>
							<h:outputText value="#{b.adresse}" />
						</rich:column>
						<rich:column sortable="true" sortBy="#{b.num_tel}" width="150px"
							label="numtel ">
							<f:facet name="header">
								<h:outputText value="numéro téléphone" />
							</f:facet>
							<h:outputText value="#{b.num_tel}" />
						</rich:column>
						<rich:column sortable="true" sortBy="#{b.num_fax}" width="80px"
							label="numfax ">
							<f:facet name="header">
								<h:outputText value="numéro fax" />
							</f:facet>
							<h:outputText value="#{b.num_fax}" />
						</rich:column>
						<rich:column sortable="true" sortBy="#{b.mot_cle}" width="80px"
							label="mot_cle ">
							<f:facet name="header">
								<h:outputText value="mot clé" />
							</f:facet>
							<h:outputText value="#{b.mot_cle}" />
						</rich:column>
						<rich:column sortable="true" sortBy="#{b.emailetab}" width="130px"
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
							width="150px" label="nbretd ">
							<f:facet name="header">
								<h:outputText value="nombre étudiant" />
							</f:facet>
							<h:outputText value="#{b.nbr_etudiant}" />
						</rich:column>



						<a4j:support event="onselectionchange" reRender="restable"
							ajaxSingle="true" action="#{etablissementCtrl.takeSelection}"></a4j:support>


					</rich:extendedDataTable>
				</rich:panel>

				<rich:panel id="restable8" style="width:1020">
					<f:facet name="header">
						<h:outputText value="Etablissement selected" />
					</f:facet>
					<rich:dataGrid columns="1"
						value="#{etablissementCtrl.selectedEtablissements}" var="cap"
						rendered="#{not empty etablissementCtrl.selectedEtablissements}">
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
		</rich:tab>


	</rich:tabPanel>

	</body>
	</html>
</f:view>