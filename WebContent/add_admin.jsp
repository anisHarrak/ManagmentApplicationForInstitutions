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

	<title>Add Admin</title>

	</head>
	<body>
	<rich:panel style="width:450">
		<f:facet name="header">
			<h:outputText value="Saisir Un Admin"></h:outputText>
		</f:facet>

		<h:panelGrid >
			<h:form >
				<rich:layout >
					<rich:layoutPanel position="left" width="200">
						<h:panelGrid>

							<h:outputText value="Login Admin:" />
							<h:inputText id="login"
								value="#{adminCtrl.newAdmin.login}" required="false" />

							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{adminCtrl.messageValLogin}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>

							<h:outputText value="Mot de passe:" />
							<h:inputSecret id="motdepasse"
								value="#{adminCtrl.newAdmin.mot_de_passe}" required="false" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{adminCtrl.messageValMot_de_passe}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		  <h:commandButton value="Ajouter"
								action="#{adminCtrl.createAdmin}" />
						</h:panelGrid>
					</rich:layoutPanel>

					<rich:layoutPanel position="right" width="200" >

						<h:panelGrid>
							<h:outputText value="Numéro d'Admin:" />
							<h:inputText id="numadmin"
								value="#{adminCtrl.newAdmin.numero_admin}" required="false" />

							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{adminCtrl.messageValNumero_admin}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>

							<h:outputText value="Type User:" />
							<h:inputText id="type"
								value="#{adminCtrl.newAdmin.type_user}" required="false" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{adminCtrl.messageValType_user}"></h:outputLabel>
							<h:outputText />
							<div class="div_near_spacer"></div>
			


						</h:panelGrid>
					</rich:layoutPanel>



				</rich:layout>
			</h:form>
		</h:panelGrid>

	</rich:panel>

	</body>
	</html>
</f:view>