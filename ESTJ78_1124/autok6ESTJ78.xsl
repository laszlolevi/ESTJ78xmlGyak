<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match="/" >
    <html>
    	<body>
    
        <xsl:element name="eredmeny">
            <xsl:for-each-group select="//auto" group-by="tulaj/varos/text()">
                <xsl:element name="varos">
                    <xsl:element name="nev">
                          <xsl:value-of select="current-grouping-key()"/></xsl:element>
                    <xsl:element name="db">
                          <xsl:value-of select="count( current-group())"/></xsl:element>
                    <xsl:element name="összár">
                          <xsl:value-of select="sum( current-group()/ar)"/></xsl:element>                    
                </xsl:element>
            </xsl:for-each-group>
        </xsl:element>
       </body>
    </html>
    </xsl:template>
</xsl:stylesheet>
