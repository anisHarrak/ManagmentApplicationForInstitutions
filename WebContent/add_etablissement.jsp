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

	<title>Add Etablissement</title>

	</head>
	<body>
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="Saisir Un Etablissement"></h:outputText>
		</f:facet>

		<h:panelGrid>
			<h:form>
				<rich:layout>
					<rich:layoutPanel position="left">
						<h:panelGrid>

							<h:outputText value="Nom de l'établissement:" />
							<h:inputText id="nom"
								value="#{etablissementCtrl.newEtablissement.nom_etab}" required="false" />

							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{etablissementCtrl.messageValNOM}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>

							<h:outputText value="Adresse de l'établissement:" />
							<h:inputText id="adresse" value="#{etablissementCtrl.newEtablissement.adresse_etab}"
								required="false" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{etablissementCtrl.messageValAdresse}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>

							<h:outputText value="Numéro de téléphone de l'établissement:" />
							<h:inputText id="numtel"
								value="#{etablissementCtrl.newEtablissement.num_tel}" required="false" />
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

	</body>
	</html>
</f:view>