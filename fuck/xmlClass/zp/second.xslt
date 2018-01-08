<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html" encoding="gb2312"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>学生信息显示</title>
			</head>
			<body>
				<h3 align="center">学生信息显示</h3>
				<xsl:apply-templates select="//学生列表" mode="x"/>
				<xsl:apply-templates select="//学生列表" mode="y"/>
				<xsl:apply-templates select="//学生列表" mode="z"/>
				<xsl:apply-templates select="//学生列表" mode="w"/>
			</body>
	</html>
	</xsl:template>
	<xsl:template match="//学生列表" mode="x">
	    <xsl:for-each select="//学生">
	    <xsl:choose>
			<xsl:when test="性别='男'">
	        <font color="blue">
	        <ul>
			    <li>编号：<xsl:value-of select="position()"/></li>
			    <li>学号：<xsl:value-of select="学号"/></li>
			    <li>姓名：<xsl:value-of select="姓名"/></li>
			    <li>性别：<xsl:value-of select="性别"/></li>
			    <li>班级：<xsl:value-of select="班级"/></li>
			    <li>年龄：<xsl:value-of select="年龄"/></li>
		    </ul>
		    </font>
		    </xsl:when>
		    <xsl:otherwise>
	        <font color="red">
	        <ul>
			    <li>编号：<xsl:value-of select="position()"/></li>
			    <li>学号：<xsl:value-of select="学号"/></li>
			    <li>姓名：<xsl:value-of select="姓名"/></li>
			    <li>性别：<xsl:value-of select="性别"/></li>
			    <li>班级：<xsl:value-of select="班级"/></li>
			    <li>年龄：<xsl:value-of select="年龄"/></li>
		    </ul>
		    </font>
		    </xsl:otherwise>
		</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="//学生列表" mode="y">
	    <xsl:for-each select="//学生">
	    <xsl:choose>
			<xsl:when test="班级=1">
	        <ul style="background-color:yellow">
			    <li>编号：<xsl:value-of select="position()"/></li>
			    <li>学号：<xsl:value-of select="学号"/></li>
			    <li>姓名：<xsl:value-of select="姓名"/></li>
			    <li>性别：<xsl:value-of select="性别"/></li>
			    <li>班级：<xsl:value-of select="班级"/></li>
			    <li>年龄：<xsl:value-of select="年龄"/></li>
		    </ul>
		    </xsl:when>
		    <xsl:otherwise>
	        <ul style="background-color:grey">
			    <li>编号：<xsl:value-of select="position()"/></li>
			    <li>学号：<xsl:value-of select="学号"/></li>
			    <li>姓名：<xsl:value-of select="姓名"/></li>
			    <li>性别：<xsl:value-of select="性别"/></li>
			    <li>班级：<xsl:value-of select="班级"/></li>
			    <li>年龄：<xsl:value-of select="年龄"/></li>
		    </ul>
		    </xsl:otherwise>
		</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="//学生列表" mode="z">
	    <xsl:for-each select="//学生">
	    <xsl:if test="年龄 &gt; 25">
	        <ul>
			    <li>编号：<xsl:value-of select="position()"/></li>
			    <li>学号：<xsl:value-of select="学号"/></li>
			    <li>姓名：<xsl:value-of select="姓名"/></li>
			    <li>性别：<xsl:value-of select="性别"/></li>
			    <li>班级：<xsl:value-of select="班级"/></li>
			    <li>年龄：<xsl:value-of select="年龄"/></li>
		    </ul>   
	    </xsl:if>
	    </xsl:for-each>
	</xsl:template>
	<xsl:template match="//学生列表" mode="w">
	    <table border="1" align="center">
			<tbody>
				<tr>
					<th>编号</th>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>班级</th>
					<th>年龄</th>
				</tr>
				<xsl:for-each select="//学生">
		        <xsl:if test="班级=2">
		            <tr>
				        <td>
					        <xsl:value-of select="position()-4"/>
				        </td>
				        <td>
					        <xsl:value-of select="学号"/>
				        </td>
				        <td>
					        <xsl:value-of select="姓名"/>
				        </td>
				        <td>
					        <xsl:value-of select="性别"/>
				        </td>
				        <td>
					        <xsl:value-of select="班级"/>
				        </td>
				        <td>
					        <xsl:value-of select="年龄"/>
				        </td>
			        </tr>
		        </xsl:if>		
		        </xsl:for-each>
		    </tbody>
		</table>    
	</xsl:template>
</xsl:stylesheet>
