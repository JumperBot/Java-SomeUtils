import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.lang.Process;
import java.lang.Runtime;
import java.lang.StringBuilder;

import java.util.Scanner;

class DirectoryMaintainer{
  public static void main(String[]a)throws Exception{
    final StringBuilder builder=new StringBuilder("# Welcome to SomeUtils contributing guide\n\nWe (as one entity) salute you for actually trying to read this contributing guide.\n\nAny contribution you make will be reflected/commited to this repository, so be careful on what you're doing! \n\nRead our [Code of Conduct](./CODE_OF_CONDUCT.md) to keep our community approachable and respectable.\n\nIn this guide you will get an overview of the contribution workflow from opening an issue, creating a PR, reviewing, and merging the PR.\n\nUse the table of contents icon <img src=\"https://github.com/github/docs/blob/7ada1b26cf14e242d78ddf021ab743158b6a87f2/assets/images/table-of-contents.png\" width=\"20em\" height=\"20em\" /> on the top left corner of this document to get to a specific section of this guide quickly.\n\n## New contributor guide\n\nTo get an overview of the project, read the [README](README.md).\n\nHere are some resources to help you get started with open source contributions (as for GitHub Docs default):\n\n- [Finding ways to contribute to open source on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github)\n- [Set up Git](https://docs.github.com/en/get-started/quickstart/set-up-git)\n- [GitHub flow](https://docs.github.com/en/get-started/quickstart/github-flow)\n- [Collaborating with pull requests](https://docs.github.com/en/github/collaborating-with-pull-requests)\n\n\n## Navigating the repository\n\nTo navigate the repository without wasting time and bandwidth.\n\nShould be automatically updated (theoretically) after every commit.\n\n<details>\n<summary>&nbsp&nbsp&nbsp └── Repository</summary>\n\n```shell\n");
    final Process proc=Runtime.getRuntime().exec("tree "+System.getProperty("user.dir"));
    try{
      proc.waitFor();
    }catch(Exception e){}
    try(final Scanner outputReader=new Scanner(new InputStreamReader(proc.getInputStream()))){
      //No need to optimize, unlimited action minutes~
      while(outputReader.hasNext()){
        final String line=outputReader.nextLine().replaceAll("^/.*", "");
        if(!line.isEmpty()&&outputReader.hasNext())
          builder.append("     ").append(line+"\n");
      }
    }
    builder.append("```\n\n</details>\n\n### Issues\n\n#### Create a new issue\n\nIf you spot a problem with the docs, [search if an issue already exists](https://docs.github.com/en/github/searching-for-information-on-github/searching-on-github/searching-issues-and-pull-requests#search-by-the-title-body-or-comments).\n\nIf a related issue doesn't exist, you can open a new issue using a relevant [issue form](https://github.com/JumperBot/SomeUtils/issues/new/choose). \n\n#### Solve an issue\n\nScan through our [existing issues](https://github.com/JumperBot/SomeUtils/issues) to find one that interests you.\n\nYou can narrow down the search at will using filters.\n\nIf you find an issue to work on, you are welcome to open a [PR](https://github.com/JumperBot/SomeUtils/compare) with a fix.\n\nRemember, fill up the form to give us as much information as possible!");
    final File file=new File("CONTRIBUTING.md");
    file.delete();
    file.createNewFile();
    try(final FileWriter writer=new FileWriter(file)){
      writer.write(builder.toString());
    }
  }
}
