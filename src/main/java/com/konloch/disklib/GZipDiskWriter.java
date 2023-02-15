package com.konloch.disklib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Small disk writing util, with gzip compression built in
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class GZipDiskWriter
{
    private static final String EMPTY = "";
    
    /**
     * Appends nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file) throws IOException
    {
        append(file, false);
    }
    
    /**
     * Appends nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file) throws IOException
    {
        append(file, false);
    }
    
    /**
     * Appends nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file, boolean appendNewLine) throws IOException
    {
        append(new File(file), appendNewLine ? EMPTY + System.lineSeparator() : EMPTY);
    }
    
    /**
     * Appends nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file, boolean appendNewLine) throws IOException
    {
        append(file, appendNewLine ? EMPTY + System.lineSeparator() : EMPTY);
    }
    
    /**
     * Appends a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file, String line) throws IOException
    {
        append(file, line, false);
    }
    
    /**
     * Appends a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file, String line) throws IOException
    {
        append(file, line, false);
    }
    
    /**
     * Appends a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file, String line, boolean appendNewLine) throws IOException
    {
        append(new File(file), appendNewLine ? line + System.lineSeparator() : line);
    }
    
    /**
     * Appends a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file, String line, boolean appendNewLine) throws IOException
    {
        append(file, (appendNewLine ? line + System.lineSeparator() : line).getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * Appends a String Collection to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param linesToWrite String Collection lines to write
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file, Collection<String> linesToWrite) throws IOException
    {
        append(new File(file), linesToWrite);
    }
    
    /**
     * Appends a String Collection to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file object
     * @param linesToWrite String Collection lines to write
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file, Collection<String> linesToWrite) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        for (String s : linesToWrite)
            if(sb.length() != 0)
                sb.append(System.lineSeparator()).append(s);
            else
                sb.append(s);
        
        write(file, sb.toString().getBytes(StandardCharsets.UTF_8), true);
    }
    
    /**
     * Appends a byte Array to the specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param fileContents byte Array of any size
     * @throws IOException if an I/O error occurs
     */
    public static void append(String file, byte[] fileContents) throws IOException
    {
        write(new File(file), fileContents, true);
    }
    
    /**
     * Appends a byte Array to the specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file object
     * @param fileContents byte Array of any size
     * @throws IOException if an I/O error occurs
     */
    public static void append(File file, byte[] fileContents) throws IOException
    {
        write(file, fileContents, true);
    }
    
    /**
     * Writes nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file) throws IOException
    {
        write(file, false);
    }
    
    /**
     * Writes nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file) throws IOException
    {
        write(file, false);
    }
    
    /**
     * Writes nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file, boolean appendNewLine) throws IOException
    {
        write(new File(file), appendNewLine ? EMPTY + System.lineSeparator() : EMPTY);
    }
    
    /**
     * Writes nothing to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file, boolean appendNewLine) throws IOException
    {
        write(file, appendNewLine ? EMPTY + System.lineSeparator() : EMPTY);
    }
    
    /**
     * Writes a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file, String line) throws IOException
    {
        write(file, line, false);
    }
    
    /**
     * Writes a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file, String line) throws IOException
    {
        write(file, line, false);
    }
    
    /**
     * Writes a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file, String line, boolean appendNewLine) throws IOException
    {
        write(new File(file), appendNewLine ? line + System.lineSeparator() : line);
    }
    
    /**
     * Writes a String to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param line String to write
     * @param appendNewLine true to append a new line
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file, String line, boolean appendNewLine) throws IOException
    {
        write(file, (appendNewLine ? line + System.lineSeparator() : line).getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * Writes a String Collection to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param linesToWrite String Collection lines to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file, Collection<String> linesToWrite) throws IOException
    {
        write(new File(file), linesToWrite);
    }
    
    /**
     * Writes a String Collection to a specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file object
     * @param linesToWrite String Collection lines to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file, Collection<String> linesToWrite) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        for (String s : linesToWrite)
            if(sb.length() != 0)
                sb.append(System.lineSeparator()).append(s);
            else
                sb.append(s);
        
        write(file, sb.toString().getBytes(StandardCharsets.UTF_8), false);
    }
    
    /**
     * Writes a byte Array to the specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file path to open
     * @param fileContents byte Array of any size
     * @throws IOException if an I/O error occurs
     */
    public static void write(String file, byte[] fileContents) throws IOException
    {
        write(new File(file), fileContents, false);
    }
    
    /**
     * Writes a byte Array to the specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file any valid file object
     * @param fileContents byte Array of any size
     * @throws IOException if an I/O error occurs
     */
    public static void write(File file, byte[] fileContents) throws IOException
    {
        write(file, fileContents, false);
    }
    
    /**
     * Writes or appends a byte Array to the specified file.
     * If the file doesn't exist it will automatically create it.
     *
     * @param file the file object to open
     * @param fileContents byte Array of any size
     * @param append true to append files, false to overwrite files
     * @throws IOException if an I/O error occurs
     */
    private static void write(File file, byte[] fileContents, boolean append) throws IOException
    {
        FileOutputStream writer = null;
        try
        {
            writer = new FileOutputStream(file, append);
            writer.write(GZip.compress(fileContents));
        }
        finally
        {
            if (writer != null)
                try
                {
                    writer.close();
                } catch (Exception ex) {}
        }
    }
}