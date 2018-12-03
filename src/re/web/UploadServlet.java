package re.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.servlet.*;
import re.util.Methods;

@WebServlet(name = "UploadServlet", urlPatterns = "/us")
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;      // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;      // 10MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50;       // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = null;
        System.out.println("success");

        if(request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        if(action.equalsIgnoreCase("upload")) {
            String filePath = "";
            String fileName = "";
            String newFileName = "";
            if(!ServletFileUpload.isMultipartContent(request)) {
                response.getWriter().println("Doesn't support!");
                //if not, we stop here
                return;
            }

            //configure some settings
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(THRESHOLD_SIZE);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(REQUEST_SIZE);
            System.out.println(getServletContext().getRealPath(""));
            // constructs the directory path to store upload file
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            //creates the directory if do not exist
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                //parses the request's content to extract file data
                List formItems = upload.parseRequest(request);
                Iterator iter = formItems.iterator();
                //UUID uuid = UUID.randomUUID();
                String ending = Methods.addEndingToFileName();

                //iterates over form's fields
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    //process only fields that are not form fields
                    if(!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        String newName = fileName.substring(0, fileName.lastIndexOf(".")) + "_" + ending;
                        newFileName = fileName.replace(fileName.substring(0, fileName.lastIndexOf(".")), newName);
                        // System.out.println("FileName = " + fileName);
                        filePath = uploadPath + File.separator + newFileName;
                        System.out.println("File Path = " + filePath);
                        File storeFile = new File(filePath);

                        //saves the file on disk
                        item.write(storeFile);
                    } else {
                        if(item.getFieldName().equalsIgnoreCase("studentName")) {
                            String studentName = item.getString();
                            System.out.println("Student Name = " + studentName);
                        }
                    }
                    request.setAttribute("imagePath2", UPLOAD_DIRECTORY + File.separator + newFileName);
                    request.setAttribute("imagePath", filePath);
                    request.setAttribute("message", "Upload has been done successfully!");
                }
            } catch (Exception e) {
                request.setAttribute("message", "There was an error: " + e.getMessage());
                e.printStackTrace();
            }
            request.getRequestDispatcher("/view.jsp").forward(request, response);
        } else if(action.equalsIgnoreCase("download")) {
            try {
                /* Real proyekt ucun
                     int houseAnnounceId = xxx;
                     HouseAnnounce houseAnnounce = houseService.getHouseAnnounceById(houseAnnounceId);
                     System.out.println(houseAnnounce.imageFullPath);
                 */
                String filePath = request.getParameter("fileName");
                //String filePath = houseAnnounce.imageFullPath;

                File downloadFile = new File(filePath);
                FileInputStream inStream = new FileInputStream(downloadFile);

                ServletContext context = getServletContext();

                //gets MIME types of the file
                String mimeType = context.getMimeType(filePath);
                if (mimeType == null) {
                    // set to binary type if MIME mapping not found
                    mimeType = "application/octet-stream";
                }
                System.out.println("MIME type = " + mimeType);

                //modifies response
                response.setContentType(mimeType);
                response.setContentLength((int) downloadFile.length());

                //forces download
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
                response.setHeader(headerKey, headerValue);

                //obtains response's output stream
                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while((bytesRead = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

                inStream.close();
                outStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
