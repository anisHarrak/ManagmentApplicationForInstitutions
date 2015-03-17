<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<%@page import="control.AdminCtrl"%>
<%@page import="control.PersonnelCtrl"%>
<%@page import="control.VisiteurCtrl"%>
<%@page import="control.UtilisateurCtrl"%>
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

	<title>s'authentifier</title>

	</head>
	<body>
	<rich:panel style="width:400" >
		<f:facet name="header">
			<h:outputText value="Connexion" />
		</f:facet>
		<h:panelGrid>
			<h:form>
				<rich:layout>

					<rich:layoutPanel position="left">
						<h:panelGrid>
							<h4><h:outputText value="Login:"></h:outputText></h4>
							<h:inputText required="false"
								value="#{utilisateurCtrl.newUtilisateur.login}" />

							<h:outputLabel
								style="color:red;font-family:arial, verdana;font-size:12px; text-decoration: none font-weight: bold;"
								value="#{utilisateurCtrl.messageValtest}"></h:outputLabel>
								</h:panelGrid>
								<h:panelGrid>
								<h4><h:outputText value="Mot de passe:"></h:outputText></h4>
							<h:inputText required="false"
								value="#{utilisateurCtrl.newUtilisateur.mot_de_passe}" />

							<h:outputLabel
								style="color:red;font-family:arial, verdana;font-size:12px; text-decoration: none font-weight: bold;"
								value="#{utilisateurCtrl.messageValtest}"></h:outputLabel>
							<h:commandButton image="/connx.png" value="Se Connecter" style="width:154"
								action="#{utilisateurCtrl.connecter}" />
							<br></br>
							<h:outputLabel
								style="color:red;font-family:arial, verdana;font-size:12px; text-decoration: none font-weight: bold;"
								value="#{utilisateurCtrl.messageValtest2}"></h:outputLabel>
								<br></br>
							<h:graphicImage width="350" height="90" value="/connexion.jpg"></h:graphicImage>

						</h:panelGrid>
					</rich:layoutPanel>
				</rich:layout>
			</h:form>
		</h:panelGrid>
	</rich:panel>
	</body>
	</html>
</f:view>