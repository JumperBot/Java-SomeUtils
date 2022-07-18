# Welcome to SomeUtils contributing guide

We (as one entity) salute you for reading this contributing guide.

Any contribution you make will be reflected/commited to this repository, so be careful on what you're doing! 

Read our [Code of Conduct](./CODE_OF_CONDUCT.md) to keep our community approachable and respectable.

Use the table of contents icon <img src="https://github.com/github/docs/blob/7ada1b26cf14e242d78ddf021ab743158b6a87f2/assets/images/table-of-contents.png" width="20em" height="20em" /> on the top left corner of this document to get to a specific section of this guide quickly.

## New contributor guide

To get an overview of the project, read the [README](README.md).

Here are some resources to help you get started with open source contributions:

- [Finding ways to contribute to open source on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github)
- [Set up Git](https://docs.github.com/en/get-started/quickstart/set-up-git)
- [GitHub flow](https://docs.github.com/en/get-started/quickstart/github-flow)
- [Collaborating with pull requests](https://docs.github.com/en/github/collaborating-with-pull-requests)

To give us a suggestion on what utility to do next, you can open up an [issue](https://github.com/JumperBot/Java-SomeUtils/issues/new/choose).

### How to start writing "the" code

The first and most important step is getting to know yourself and your setup:
  - Can you write code in `Java`?
    - Can you understand it's syntax ***properly***?
    - Can you solve common problems that occur when writing a program?
      - Have you experienced coding alone with no help?
      - Do you know when and how to ask for help on sites like [StackOverflow](https://stackoverflow.com/)? 
    - Do you have your `Java` environment setup ready?
      - Do you have a JDK that supports `Java-8` and above? *(persionally using Java-11)*
        - Check it with `java --version` on your terminal.
  - Do you know how to use `Git` or `GitHub` ***properly***?

Next steop would be ***\*drum-roll\**** forking the repository!
  - You can now write the actual code.

### What to do when writing the code

  - Make the code concise.
  - Make the code compact.
  - Make the code readable.
    - Don't make it ***too readable*** or else we won't be accepting it!
    - Also, don't make the code ***too unreadable*** or else we won't be accepting it as well!
  - Always include a demo
    - Take a look at some of our files to know what I meant by that.
  - Include as much functionality as possible only when practical.
    - In other words, don't make `god classes` please.
  - Follow the [directory](./CONTRIBUTING.md#navigating-the-repository) as a basis on how your contribution should look like when looking at it's directory tree.
  - Never forget to test and compile the code first on your machine before making such reckless moves!

### What to do after writing the code

  - Check, test and compile your code into it's appropriate directory.
  - Commit your changes into your fork.
    - Use [Gitmojis](https://gitmoji.kaki87.net/) before your commit message to indicate what your commit is for.  
  - Open up a [PR](https://github.com/JumperBot/Java-SomeUtils/compare).
    - Fill up the form!
  - Wait for me to accept your changes!

## Navigating the repository

To navigate the repository without wasting time and bandwidth.

Should be automatically updated after every commit.

```shell
     ├── .github
     │   ├── CODE_OF_CONDUCT.md
     │   ├── CONTRIBUTING.md
     │   ├── DirectoryMaintainer.java
     │   ├── ISSUE_TEMPLATE
     │   │   ├── bug_report.md
     │   │   └── feature_request.md
     │   ├── Logo.apng
     │   ├── pull_request_template.md
     │   └── workflows
     │       ├── code_checker.yml
     │       ├── delete_workflow_history.yml
     │       └── directory_maintainer.yml
     ├── LICENSE
     ├── README.md
     ├── build
     │   └── SomeUtils
     │       ├── Clock
     │       │   ├── Alarm$1.class
     │       │   ├── Alarm$2.class
     │       │   ├── Alarm$AlarmWatcher.class
     │       │   ├── Alarm.class
     │       │   ├── Stopwatch.class
     │       │   ├── Timer$1.class
     │       │   ├── Timer$TimerWatcher.class
     │       │   └── Timer.class
     │       ├── DynamicArray
     │       │   └── DynamicArray.class
     │       ├── Pattern
     │       │   └── PatternFinder.class
     │       ├── ProgressBar
     │       │   └── ProgressBar.class
     │       └── TerminalMap
     │           └── TerminalMap.class
     └── src
         └── SomeUtils
             ├── Clock
             │   ├── Alarm.java
             │   ├── README.md
             │   ├── Stopwatch.java
             │   └── Timer.java
             ├── DynamicArray
             │   ├── DynamicArray.java
             │   └── README.md
             ├── Pattern
             │   ├── PatternFinder.java
             │   └── README.md
             ├── ProgressBar
             │   ├── ProgressBar.java
             │   └── README.md
             └── TerminalMap
                 ├── README.md
                 └── TerminalMap.java
```

## Issues

### Create a new issue

If you spotted a problem or would like to create a new issue, [search if an issue already exists](https://docs.github.com/en/github/searching-for-information-on-github/searching-on-github/searching-issues-and-pull-requests#search-by-the-title-body-or-comments).

If a related issue doesn't exist, you can open a new issue using a relevant [issue form](https://github.com/JumperBot/Java-SomeUtils/issues/new/choose). 

### Solve an issue

Scan through our [existing issues](https://github.com/JumperBot/Java-SomeUtils/issues) to find one that interests you.

You can narrow down the search at will using filters.

If you find an issue to work on, you are welcome to fork this repository and open up a [PR](https://github.com/JumperBot/Java-SomeUtils/compare) containing your fix.

Remember, fill up the forms to give us as much information as possible!
