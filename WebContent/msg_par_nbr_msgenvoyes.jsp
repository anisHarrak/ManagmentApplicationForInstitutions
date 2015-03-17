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
	border-right-width: 0px;
}
.div{
	
	float: left;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>Statistiques par opérateur</title>

	</head>
	<body>
	<rich:panel style="width:400">
		<f:facet name="header">
			<h:outputText value="Statistiques par opérateur"></h:outputText>
		</f:facet>

		<h:panelGrid>
			<h:form>
				<rich:layout>
					<rich:layoutPanel position="left" width="190">
						<h:panelGrid>

							<h:outputText value="Nombre de messages envoyés:" />
							<h:outputLabel
								style="color: red;font-family:arial, verdana;
	font-size:12px; text-decoration: none font-weight: bold;"
								value="#{sms_inscritCtrl.messageValnbrmsg}"></h:outputLabel>
							<h:outputText />

							<div class="div_near_spacer"></div>
							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>

							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>
						

							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		  <h:commandButton value="Statistique" style="color:blue"
								action="#{sms_inscritCtrl.calculeNbrMsgEnvoyes}" />
						</h:panelGrid>
					</rich:layoutPanel>
					<rich:layoutPanel position="right" width="135">
						<h:panelGrid>
							<div class="div_near_spacer"></div>
							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>

							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>
							<div class="div_near_spacer"></div>
							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>
							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>
							<div class="div_near_spacer"></div>

							
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="div_near_spacer"></div>



							<h:commandButton value="Mettre à zéro" style="color:blue"
								action="#{sms_inscritCtrl.clean}" />
								<div class="div_near_spacer"></div>
								<div class="div_near_spacer"></div>
								
							<div ><h:commandButton image="/accueil.png" value="" style="width:50;height:45"
								action="#{sms_inscritCtrl.toAccueil}" /></div>
						</h:panelGrid>
					</rich:layoutPanel>

				</rich:layout>
			</h:form>
		</h:panelGrid>

	</rich:panel>

	</body>
	</html>
</f:view>