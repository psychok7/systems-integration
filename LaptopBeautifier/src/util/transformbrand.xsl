<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/lista">
		<html>
			<head>
				<title>
					<xsl:value-of select="@marca" />
				</title>
			</head>
			<body>
				<h1>
					<xsl:value-of select="@marca" />
				</h1>
				<table border="1">
					<tr>
						<td>
							<b>Modelo</b>
						</td>
						<td>
							<b>Ecrã</b>
						</td>
						<td>
							<b>Processador</b>
						</td>
						<td>
							<b>Memoria</b>
						</td>
						<td>
							<b>Disco</b>
						</td>
						<td>
							<b>Peso</b>
						</td>
						<td>
							<b>Autonomia</b>
						</td>
						<td>
							<b>Preço (€)</b>
						</td>
					</tr>
					<xsl:apply-templates />
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="modelo">
		<tr>
			<td>
				<xsl:value-of select="@nome" />
			</td>
			<td>
				<xsl:value-of select="ecra" />
			</td>
			<td>
				<xsl:value-of select="processador" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="frequenciaprocessador" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="frequenciaprocessador/@unidade" />

			</td>
			<td>
				<xsl:value-of select="memoriaram" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="memoriaram/@unidade" />
			</td>
			<td>
				<xsl:value-of select="disco" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="disco/@unidade" />
			</td>
			<td>
				<xsl:value-of select="peso" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="peso/@unidade" />

			</td>
			<td>
				<xsl:value-of select="autonomia" />
				<xsl:text> </xsl:text>
				<xsl:value-of select="autonomia/@unidade" />
			</td>
			<td>
				<xsl:value-of select="preco" />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>