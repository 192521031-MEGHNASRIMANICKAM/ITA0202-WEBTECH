<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:template match="/courses">
<html>
<head>
    <title>High Enrollment Courses</title>
</head>
<body>
    <h2>High Enrollment Courses</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Course Code</th>
            <th>Course Name</th>
            <th>Faculty</th>
            <th>Students</th>
            <th>Credits</th>
            <th>Type</th>
        </tr>
        <xsl:for-each select="course[students &gt; 30]">
            <xsl:sort select="students" order="descending" data-type="number"/>
            <tr>
                <td><xsl:value-of select="code"/></td>
                <td><xsl:value-of select="name"/></td>
                <td><xsl:value-of select="faculty"/></td>
                <td><xsl:value-of select="students"/></td>
                <td><xsl:value-of select="credits"/></td>
                <td><xsl:value-of select="type"/></td>
            </tr>
        </xsl:for-each>
    </table>
</body>
</html>
</xsl:template>

</xsl:stylesheet>
