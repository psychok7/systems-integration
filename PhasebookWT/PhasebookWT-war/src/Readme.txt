UploadBean 1.9
Copyright JavaZOOM 1999-2006
http://www.javazoom.net

==========================================================
UploadBean support page :
http://www.javazoom.net/jzservlets/uploadbean/uploadbean.html

UploadBean add-ons homepage :
http://www.javazoom.net/jzservlets/uploadbean/uploadbeantools.html

JSP Forums :
http://www.javazoom.net/services/forums/index.jsp
==========================================================

* Open documentation/index.html for instructions *


-----------------
11/08/2006 : v1.9
-----------------
- Transfer-Encoding=chunked support added for CFU parser.
- NullPointerException bug fixed for Database Upload.


-----------------
01/09/2006 : v1.8
-----------------
- DefaultDBStore improved to support optional FILESIZE and FILETYPE
  columns. UPLOADID could be setup manually and custom columns could
  be added.
- Documentation updated.

+ SQLServer 2000 support added.


-----------------
08/22/2005 : v1.7
-----------------
- WmlUpload.jsp (XHTML Mobile 1.0) sample added.
- overwritepolicy property added to improve duplicate file renaming.
- LargeUpload.jsp improved  :
   It provides advanced features for jClientUpload applet allowing
   to resume broken uploads on folderstore.
- API improved :
   getRequest() method added to MultipartFormDataRequest API.
   OverwriteFilter interface added.
- "Content-Range" header support added for folderstore.
- Documentation updated.


-----------------
02/27/2005 : v1.6
-----------------
- LargeUpload.jsp added :
   It allows to upload up to 2GB file with low memory usage.
   It also provides advanced features for jClientUpload applet allowing
   to upload mulitple files and folders through drag&drop front-end.
- Database support improved :
   Extra parameters added to DBStore API.
   verbose error messages added.

> JavaServerFaces tutorial added.
> OracleLobDBStore add-on improved : CLOB support added.

+ J2SE 1.5 support added.
+ Tomcat 5.5 support added.
+ OpenBase support added.


-----------------
12/01/2003 : v1.5
-----------------
- FormUpload.jsp sample added to learn how to get HTTP request parameters.
- Unlimited upload files bug fixed.
- Alternative filename parameter added to UploadParameters class.
  (It allows to pass renamed filename for duplicate entry when overwrite=false)
- CFU parser integration improved to support full UploadListener features.
  (It also fixes bug on CRLF drop on first line of HTML textarea field)
- Documentation updated.
- PostGreSQL script added for database store.

> ProgressStatus add-on updated :
  Cancel upload feature added.
  CFU parser support added.


-----------------
08/04/2003 : v1.4
-----------------
- Blacklist/Whitelist file extension bug fixed.
  (File extension is the last index of ".", not the first)
- setParsertmpdir directory created automatically if needed.
- Documentation/FAQ updated.

> FileMover add-on added :
  It allows to rename (copy/move) file after upload.

+ Tomcat 5.0.3alpha support added.
+ Tomcat 4.1.24 support added.
+ ServletExcec 4.1.1 support added.
+ Struts 1.1Final parser support added.
+ Commons-FileUpload 1.0 parser support added.


-----------------
02/17/2003 : v1.3
-----------------
- Recursive folders creation added for FOLDERSTORE.
- getLastId() added for DefaultDBStore.
- DefaultDBStore lock bug fixed.

> ProgressStatus add-on updated :
  Progress bar added for multiple uploads (multipleupload.jsp)

> NotifyMe add-on updated :
  JavaMail session getDefaultInstance() bug fixed.

+ WebSphere 5.0 support added.
+ WebLogic 7.0 support added.
+ SunOne 7.0 support added.
+ Tomcat 4.1.18 support added.
+ Struts 1.1b3 support added.


-------------------
12/02/2002 : v1.2.1
-------------------
- Minor bugs fixed.
+ ProgressStatus add-on available :
  This open source add-on allows to add a real-time progress bar while uploading.
+ Tomcat 4.1.12 support added.


-----------------
09/02/2002 : v1.2
-----------------
- Struts 1.1 multipart parser support added.
- Large file support improved.
- Whitelist feature added.
- API improved (UploadFile, UploadListener, Parsing package).
+ New add-ons available :
  > NotifyMe :
    This add-on allows to send an email on each upload. Uploaded file could be attached
    in the email. It's an open source add-on.
  > ChineseUpload :
    This add-on is a sample JSP allowing to upload chinese (big5) files.


-----------------
08/05/2002 : v1.1
-----------------
- Overwrite property added :
  Duplicates entries could be overwritten.
- DBStore API added :
  Developers can now add their own database store implementation if
  the default one (schema, SQL ...) doesn't suit to their needs.
- DatabaseUpload.jsp sample added.
- New Add-Ons section opened : OracleBlobDBStore Add-on available.

Engines/Application servers :
~~~~~~~~~~~~~~~~~~~~~~~~~~~
+ Tomcat 4.0.4-LE support added.
+ JRun 4.0 support added.
+ WebSphereAE 4.0.3 support added.
+ Weblogic 6.1 support added.
+ JRun 4.0 support added.

Database :
~~~~~~~~
+ Oracle8i support added.
+ Oracle9i support added.
+ IBM DB2 7.2 support added.
+ MySQL 3.23.51 support added.


-----------------
02/02/2002 : v1.0
-----------------
UploadBean - Upload component for JAVA/JSP/Servlets.
Multiple stores supported (Folder, Zip, Database, Memory).
Security features (Blacklist, FileSizeLimit, Max. Uploaded files).
Notification and history features.
Documentation (Requirements, Installation, Developer Guide, API&Design, License)
JSP Samples.

+ Tomcat 4.0.1 support.
+ Tomcat 3.2.x support.
+ JRun 3.1 support.
+ Resin 2.0.5 support.
+ WebSphere 3.5.3.
+ VisualAgeForJava 4.0.

Note :
UploadBean supports COS, STRUTS and COMMONS-FILEUPLOAD Multipart Parsers.
Learn more about COS : http://www.servlets.com/cos/index.html
Learn more about STRUTS 1.1 : http://jakarta.apache.org/struts
Learn more about COMMONS-FILEUPLOAD 1.0 : http://jakarta.apache.org/commons/fileupload/
