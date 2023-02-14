package com.konloch.disklib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

/**
 * Small disk writing util
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class DiskWriter
{
	private static final String EMPTY = "";

	/**
	 * Writes a new line to the file, if it doesn't exist it will automatically create it.
	 */
	public static void append(String file, byte[] fileContents) throws IOException
	{
		write(new File(file), fileContents, true);
	}

	/**
	 * Writes a blank new line to the file, if it doesn't exist it will automatically create it.
	 */
	public static void append(String file) throws IOException
	{
		append(new File(file), EMPTY);
	}

	/**
	 * Writes a new line to the file, if it doesn't exist it will automatically create it.
	 */
	private static void write(File file, byte[] fileContents, boolean append) throws IOException
	{
		FileOutputStream writer = null;
		try
		{
			writer = new FileOutputStream(file, append);
			writer.write(fileContents);
		}
		finally
		{
			if (writer != null)
				try
				{
					writer.close();
				}
				catch (Exception ex)
				{
				}
		}
	}

	/**
	 * Writes a string to the file
	 */
	public static void append(String file, String lineToWrite) throws IOException
	{
		append(new File(file), lineToWrite);
	}

	/**
	 * Writes a string to the file along with a new line
	 */
	public static void appendNewLine(String file, String lineToWrite) throws IOException
	{
		appendNewLine(new File(file), lineToWrite);
	}

	/**
	 * Writes a string to the file along with a new line
	 */
	public static void appendNewLine(File file, String lineToWrite) throws IOException
	{
		write(file, (lineToWrite + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), true);
	}

	/**
	 * Writes a string to the file
	 */
	public static void append(File file, String lineToWrite) throws IOException
	{
		write(file, lineToWrite.getBytes(StandardCharsets.UTF_8), true);
	}

	/**
	 * Writes a List<String> to the file
	 */
	public static void append(File file, List<String> linesToWrite) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		for (String s : linesToWrite)
			if(sb.length() != 0)
				sb.append("\n" + s);
			else
				sb.append(s);

		write(file, sb.toString().getBytes(StandardCharsets.UTF_8), true);
	}

	/**
	 * Writes a Set<String> to the file
	 */
	public static void append(File file, Set<String> linesToWrite) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		for (String s : linesToWrite)
			if(sb.length() != 0)
				sb.append("\n" + s);
			else
				sb.append(s);

		write(file, sb.toString().getBytes(StandardCharsets.UTF_8), true);
	}

	/**
	 * Deletes the original file if it exists, then writes the fileContents[] to the file.
	 */
	public static void write(String file, byte[] fileContents) throws IOException
	{
		write(new File(file), fileContents);
	}

	/**
	 * Deletes the original file if it exists, then writes the fileContents[] to the file.
	 */
	public static void write(File file, byte[] fileContents) throws IOException
	{
		if (file.exists())
			file.delete();

		write(file, fileContents, false);
	}

	/**
	 * Deletes the original file if it exists, then writes the lineToWrite to the file.
	 */
	public static void write(String file, String lineToWrite) throws IOException
	{
		write(new File(file), lineToWrite);
	}

	/**
	 * Deletes the original file if it exists, then writes the lineToWrite to the file.
	 */
	public static void write(File file, String lineToWrite) throws IOException
	{
		if (file.exists())
			file.delete();

		write(file, lineToWrite.getBytes(StandardCharsets.UTF_8), false);
	}

	/**
	 * Deletes the original file if it exists, then writes a List<String> to the file
	 */
	public static void write(String file, List<String> linesToWrite) throws IOException
	{
		write(new File(file), linesToWrite);
	}

	/**
	 * Deletes the original file if it exists, then writes a Set<String> to the file
	 */
	public static void write(String file, Set<String> linesToWrite) throws IOException
	{
		write(new File(file), linesToWrite);
	}

	/**
	 * Deletes the original file if it exists, then writes a blank file
	 */
	public static void write(String file) throws IOException
	{
		write(new File(file), EMPTY);
	}

	/**
	 * Deletes the original file if it exists, then writes a List<String> to the file
	 */
	public static void write(File file, List<String> linesToWrite) throws IOException
	{
		if (file.exists())
			file.delete();

		StringBuilder sb = new StringBuilder();
		for (String s : linesToWrite)
			if(sb.length() != 0)
				sb.append("\n" + s);
			else
				sb.append(s);

		write(file, sb.toString().getBytes(StandardCharsets.UTF_8), false);
	}

	/**
	 * Deletes the original file if it exists, then writes a Set<String> to the file
	 */
	public static void write(File file, Set<String> linesToWrite) throws IOException
	{
		if (file.exists())
			file.delete();

		StringBuilder sb = new StringBuilder();
		for (String s : linesToWrite)
			if(sb.length() != 0)
				sb.append("\n").append(s);
			else
				sb.append(s);

		write(file, sb.toString().getBytes(StandardCharsets.UTF_8), false);
	}
}