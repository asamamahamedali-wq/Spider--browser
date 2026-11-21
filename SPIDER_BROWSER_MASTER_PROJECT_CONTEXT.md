# SPIDER BROWSER --- Master Project Context & GitHub Handoff

**Document ID:** SPB-MASTER-001\
**Version:** 1.0\
**Prepared:** 2026-11-21\
**Status:** Consolidated working baseline --- reconstructed from
available conversation context; pending owner review\
**Platform:** Android\
**Development model:** Cloud-based, AI-assisted development\
**Primary language/framework:** Kotlin / Android native (proposed; final
technical decisions remain subject to approval)

------------------------------------------------------------------------

## 1. Purpose of this file

This document consolidates the available project discussions, decisions,
constraints, documentation register, review register, implementation
phases, and cloud-build instructions for **SPIDER BROWSER** into a
GitHub-ready reference.

It is a structured reconstruction of the available conversation history
and project context. It is **not a verbatim export of every chat
message**, and it does not claim to reproduce missing document text.
Where exact prior wording or evidence is unavailable, this file records
the known decision or marks the item as pending instead of inventing
details.

Use this document as the top-level project handoff and governance index.
The detailed SPB-DOC and SPB-REVIEW documents should remain separate
files when their full contents are available.

## 2. Project vision

SPIDER BROWSER is intended to be a native Android application combining
three connected capabilities:

1.  **Smart web browser** --- a polished browser experience with tab and
    session management, browsing history, bookmarks, private browsing,
    site permissions, reading/translation/sharing tools, and
    browser-to-download integration.
2.  **Advanced download manager** --- URL-based downloads, queue
    management, pause/resume where supported, retry handling,
    scheduling, progress/speed display, categorization, background
    execution, and file organization.
3.  **AI assistance layer** --- optional assistance for browsing,
    downloads, and file organization, designed as a modular capability
    rather than a dependency for core browsing or downloading.

The product should be a real, functional Android application, not a
static UI demonstration. Visible controls must have defined behavior and
be tested. The browser and download manager should remain useful when
optional AI services are unavailable.

## 3. Product principles and functional boundaries

### 3.1 Browser

The intended browser scope includes: - Address/search input and
navigation. - Back, forward, reload, and home behavior. - Tab creation,
switching, and closing. - Browsing history and bookmarks. - Private
browsing with clearly defined data-retention behavior. - Website
permission controls. - Page sharing, reading-related tools, and
translation where technically and legally supported. - Integration with
the download manager.

A WebView is a rendering component, not a complete browser by itself.
Browser functions, navigation policy, state management, permissions,
downloads, and privacy controls must be implemented around it.

### 3.2 Download manager

The intended download scope includes: - Add a download from a URL. -
Queue and task states. - Pause and resume when supported by the server
and transfer implementation. - Retry after recoverable failures. -
Progress, transfer status, and speed display. - File categories and
completed/incomplete views. - Background transfer behavior appropriate
to Android platform limits. - Browser handoff so supported download
requests can be managed by the application. - Storage and
file-management controls.

Important technical qualifications: - Resume depends on server support,
such as HTTP Range requests or an equivalent mechanism. - Segmented
downloads do not guarantee higher speed; server behavior, network
conditions, and implementation determine performance. - Not every
website or media resource is downloadable. - Android background
execution is restricted. Use platform-appropriate mechanisms such as
WorkManager or a foreground service only where justified and compliant
with current Android requirements.

### 3.3 AI assistance

-   AI features are modular and optional.
-   Core browsing and downloading must not fail merely because an AI
    provider is unavailable.
-   Do not hardcode API keys, tokens, or provider secrets in the APK or
    source repository.
-   Treat page content and downloaded files as untrusted input.
-   Private-browsing data must not be sent to an external AI service by
    default.
-   Any external AI transfer must have a clear user-facing purpose,
    disclosure, and appropriate user control.
-   Respect website terms, copyright, access controls, and platform
    policies. Do not bypass DRM or site restrictions.

## 4. User-approved project settings

The following are explicit project-level decisions from the available
conversation context:

  -----------------------------------------------------------------------
  Item                                Current decision
  ----------------------------------- -----------------------------------
  Target platform                     Android

  Development environment             Cloud-based

  Development approach                AI-assisted; provider-neutral /
                                      "other" coding assistant

  Documentation depth                 Maximum

  Initial build goal                  Prove the cloud build environment
                                      and produce a test Debug APK before
                                      feature development

  Initial implementation phase        PH-00

  Account actions                     No account connection or
                                      account-level action without
                                      explicit user approval

  Permissions                         No authorization or permission
                                      grant without explicit user
                                      approval

  Costs                               No payment, subscription, billing
                                      activation, or cost-incurring
                                      action without explicit user
                                      approval

  User execution preference           User requested detailed
                                      instructions to connect GitHub and
                                      Codemagic personally; no
                                      assistant-side account action
  -----------------------------------------------------------------------

These approvals do **not** authorize repository creation, GitHub App
installation, Codemagic authorization, billing activation, signing-key
creation, release publication, or other account operations.

## 5. Proposed cloud workflow

The proposed workflow is:

`GitHub (source and documentation) → GitHub Codespaces (optional cloud editing environment) → Codemagic (cloud Android build) → downloadable Debug APK`

Status: **proposed workflow, not confirmed as operational**.

-   GitHub is the source-control and documentation home.
-   Codespaces may provide a browser-based development environment; it
    is optional for the CI build path.
-   Codemagic may run the Gradle Android build and retain APK artifacts.
-   The first proof should be a Debug APK, not a production release.
-   A successful YAML configuration or a written plan is not evidence of
    a successful build. Evidence requires an actual completed build and
    a retrievable APK artifact.

The user requested instructions only for personally linking GitHub and
Codemagic. Do not claim that either service has been connected by the
assistant.

## 6. Cloud account, permission, and cost safety rules

These rules are mandatory project constraints:

1.  Never connect, authorize, install, or modify an account integration
    on the user's behalf without explicit approval for that specific
    action.
2.  Never request passwords, one-time codes, personal access tokens,
    private keys, or signing secrets in chat.
3.  Never add a payment method, enable billing, start a paid
    subscription, or knowingly trigger a paid build without explicit
    approval.
4.  Prefer repository-scoped access over access to all repositories when
    the service supports it.
5.  Review requested GitHub App permissions before the user approves
    them.
6.  If a payment, upgrade, billing, or unexpected permission screen
    appears, stop and ask the user to decide.
7.  Do not treat a free quota as unlimited. Check the account's current
    plan, build machine type, included minutes, and overage behavior
    before running builds.
8.  Keep private repositories private unless the user explicitly decides
    otherwise.
9.  Keep secrets out of Git history. Use the CI provider's secure
    environment-variable or secret-management feature only when needed
    and approved.
10. Do not publish a signed release or distribute an APK publicly during
    PH-00.

## 7. GitHub and Codemagic setup --- user-operated procedure

This section is an operational checklist, not authorization for the
assistant to act.

### 7.1 GitHub repository

Suggested repository name: `spider-browser`\
Suggested visibility: `Private`

User-operated steps: 1. Sign in to GitHub. 2. Create a repository named
`spider-browser`, if one does not already exist. 3. Select Private
visibility. 4. Avoid uploading credentials, signing keys, API keys, or
private configuration. 5. Keep the repository empty until the approved
starter project is ready, or initialize it only if the project
instructions explicitly require it.

### 7.2 Codemagic account and integration

1.  Open Codemagic and sign in or create an account personally.
2.  Choose GitHub as the source provider.
3.  Review the GitHub authorization and GitHub App installation screens.
4.  If repository selection is offered, prefer **Only select
    repositories** and select only `spider-browser`.
5.  Do not grant broader access than required.
6.  Do not accept a paid upgrade or enter payment details.
7.  Add the repository as a Codemagic application only after the
    integration is configured.
8.  Confirm that the application appears in the Codemagic Applications
    list.

If the repository is not visible, review the integration's repository
access configuration. Do not solve visibility problems by granting
all-repository access unless the user explicitly chooses that after
reviewing the implications.

### 7.3 Optional Codespaces

Codespaces is an optional cloud editor, not a prerequisite for
Codemagic. Before starting a Codespace, check the included quota and the
account's spending controls. Do not enable paid usage or add billing
details as part of this project setup without explicit approval.

## 8. Android build proof-of-capability

The first technical milestone is deliberately small:

-   A valid native Android project.
-   Gradle wrapper and project configuration.
-   A minimal launchable application.
-   A Codemagic workflow capable of running `./gradlew assembleDebug`.
-   A resulting APK retained as a build artifact.
-   A recorded build ID, commit hash, build result, and artifact
    filename.
-   A basic installation/launch check on a compatible Android device or
    emulator, if available.

A sample Codemagic workflow template is shown below. It must be reviewed
against the actual Android project structure and Codemagic machine
availability before use.

``` yaml
workflows:
  spider-browser-debug:
    name: SPIDER BROWSER - Debug APK
    max_build_duration: 60
    instance_type: mac_mini_m2

    scripts:
      - name: Build Debug APK
        script: |
          chmod +x ./gradlew
          ./gradlew assembleDebug

    artifacts:
      - app/build/outputs/**/*.apk
```

Notes: - The machine type above is an example, not a promise of free
availability. - Check current pricing and included build minutes in the
account before running. - If the actual project uses a different module
name or output path, update the artifact glob accordingly. - Do not add
signing configuration for a release build during this proof stage. - Do
not claim success until the build has completed and the APK artifact can
be downloaded.

## 9. Documentation register

The following project documents were identified in the planning history.
Their contents were treated as draft/pending review unless a separate
explicit approval is recorded.

  -----------------------------------------------------------------------
  ID                      Document title          Purpose
  ----------------------- ----------------------- -----------------------
  SPB-DOC-001             Project Vision          Product purpose,
                                                  audience, goals, and
                                                  boundaries

  SPB-DOC-002             Product Requirements    Product-level
                          Document (PRD)          requirements and
                                                  priorities

  SPB-DOC-003             Software Requirements   Functional and
                          Specification (SRS)     non-functional
                                                  requirements

  SPB-DOC-004             System Architecture     Modules, layers,
                          Document                boundaries, and
                                                  architecture

  SPB-DOC-005             Feature Specifications  Detailed behavior of
                                                  product features

  SPB-DOC-006             UI/UX Documentation     Visual system, screens,
                                                  navigation, RTL/LTR
                                                  behavior

  SPB-DOC-007             Database Design         Local data entities,
                                                  persistence, and
                                                  relationships

  SPB-DOC-008             API & Integration       External services and
                          Documentation           integration contracts

  SPB-DOC-009             Security & Privacy      Threats, data handling,
                                                  permissions, privacy
                                                  rules

  SPB-DOC-010             Development Roadmap     Phases, dependencies,
                                                  and sequencing

  SPB-DOC-011             Testing Plan            Test levels, cases, and
                                                  evidence

  SPB-DOC-012             Acceptance Rules        Completion and
                                                  acceptance criteria

  SPB-DOC-013             Master Build Prompt     Consolidated AI build
                                                  specification

  SPB-DOC-014             Build Instructions      Controlled
                                                  implementation
                                                  instructions

  SPB-DOC-015             Cloud Platform          Cloud tool evaluation
                          Evaluation & Selection  and selection rationale

  SPB-DOC-016             Release & APK Delivery  APK packaging and
                          Plan                    delivery process

  SPB-DOC-017             Changelog & Decision    Change history and
                          Register                decision tracking
  -----------------------------------------------------------------------

### Document status rule

The existence of a document ID or a prior draft does not mean the
document is approved. Each document must carry a visible status such
as: - `DRAFT` - `UNDER REVIEW` - `APPROVED` - `SUPERSEDED`

Only explicit owner approval changes a document to `APPROVED`.

## 10. Review register

The following reviews were identified:

  ----------------------------------------------------------------------------
  ID                      Review title            Known scope / note
  ----------------------- ----------------------- ----------------------------
  SPB-REVIEW-001          Unified Documentation   Cross-document review
                          Audit                   

  SPB-REVIEW-002          Requirements &          Requirement consistency and
                          Traceability Audit      traceability

  SPB-REVIEW-003          Architecture & Module   Architecture/module
                          Consistency Audit       alignment

  SPB-REVIEW-004          Database, API &         Data and integration
                          Integration Consistency alignment
                          Audit                   

  SPB-REVIEW-005          Security, Privacy &     Security and privacy review
                          Compliance Audit        

  SPB-REVIEW-006          UI/UX, Localization &   Interface, localization,
                          Accessibility Audit     accessibility

  SPB-REVIEW-007          Development Roadmap &   Roadmap and testing
                          Testing Consistency     alignment
                          Audit                   

  SPB-REVIEW-008          Cloud Platform & Build  Cloud readiness
                          Environment Readiness   
                          Audit                   

  SPB-REVIEW-009          Release, APK Delivery & Release governance
                          Project Governance      
                          Audit                   

  SPB-REVIEW-010          Master Documentation    Consolidated documentation
                          Baseline & Gap Closure  baseline and gaps
                          Audit                   

  SPB-REVIEW-011          Master Requirements     Requirement-to-design/test
                          Traceability &          traceability
                          Verification Matrix     

  SPB-REVIEW-012          Master Implementation   AI implementation control
                          Governance & AI Coding  and change governance
                          Execution Control       

  SPB-REVIEW-013          Not created / skipped   Do not invent a review or
                                                  its findings

  SPB-REVIEW-014          Master Technical        Technical decisions and
                          Decision Register &     stack finalization
                          Technology Stack        
                          Finalization Audit      

  SPB-REVIEW-015          Cloud Development       Cloud tool and pipeline
                          Platform & Android      selection
                          Build Pipeline          
                          Selection Audit         

  SPB-REVIEW-016          Master Repository       Repository and project
                          Structure, Source       initialization
                          Control & Project       
                          Initialization Audit    

  SPB-REVIEW-017          Project Initialization  PH-00 readiness gate
                          Readiness & PH-00 Entry 
                          Gate Audit              
  ----------------------------------------------------------------------------

Review documents are not automatically approvals. Preserve their
findings and status exactly as recorded in their full source documents
when those are added to the repository. Do not fill missing findings by
inference.

## 11. Known governance and engineering rules

1.  **No fabricated evidence:** A planned test is not a passed test. A
    configuration file is not a successful build.
2.  **Traceability:** Requirements should map to features, architecture,
    data, interfaces, and tests.
3.  **Controlled AI coding:** AI tools must follow approved documents
    and must not silently replace the architecture, delete important
    files, or broaden scope.
4.  **Change control:** Material changes to requirements, architecture,
    dependencies, permissions, or cloud costs require a recorded
    decision and appropriate approval.
5.  **Incremental delivery:** Complete and verify the foundation before
    adding feature complexity.
6.  **Build-first gate:** Prove that a minimal Android project can
    produce a downloadable APK before developing browser/download
    features.
7.  **Modularity:** Keep browser, download, AI, storage, and UI concerns
    separated through explicit module boundaries.
8.  **Privacy by design:** Minimize collection, retention, and external
    transfer of browsing data.
9.  **Localization:** The UI plan includes Arabic RTL and English LTR
    support; exact translations and screen specifications belong in
    SPB-DOC-006.
10. **Portability:** Preserve source code, Gradle configuration, and
    build instructions in GitHub so the project is not trapped in a
    single cloud IDE.
11. **No secret leakage:** Do not commit API keys, passwords, access
    tokens, keystores, or signing credentials.
12. **Acceptance evidence:** Each phase should record implementation,
    test evidence, known limitations, and owner acceptance.

## 12. Development roadmap

The planned phases are:

  -----------------------------------------------------------------------
  Phase                   Name                    High-level objective
  ----------------------- ----------------------- -----------------------
  PH-00                   Project Preparation and Establish and prove the
                          Environment Selection   cloud build path;
                                                  generate a test Debug
                                                  APK

  PH-01                   Repository and Android  Establish repository
                          Project Foundation      and native project
                                                  foundation

  PH-02                   Core Architecture and   Implement approved app
                          Application             architecture and
                          Infrastructure          infrastructure

  PH-03                   Design System and UI    Build design tokens,
                          Foundation              navigation, and UI
                                                  foundation

  PH-04                   Browser Engine          Establish browser
                          Foundation              engine integration and
                                                  lifecycle

  PH-05                   Browser Essential       Implement essential
                          Features                navigation and browsing
                                                  functions

  PH-06                   Browser Data and        Implement tabs,
                          Session Management      history, bookmarks, and
                                                  session behavior

  PH-07                   Download Engine         Establish reliable
                          Foundation              transfer engine

  PH-08                   Download Queue and      Implement queue and
                          Transfer Management     task controls

  PH-09                   Browser-to-Download     Connect browser
                          Integration             download events to
                                                  manager

  PH-10                   File Management and     Organize files and
                          Background Execution    implement compliant
                                                  background behavior

  PH-11                   Security and Privacy    Implement security and
                          Implementation          privacy controls

  PH-12                   AI Intelligence         Add modular AI provider
                          Foundation              and service foundation

  PH-13                   Advanced Browser        Add approved advanced
                          Features                browser capabilities

  PH-14                   Advanced Download       Add approved advanced
                          Features                download capabilities

  PH-15                   AI-Assisted User        Add user-facing AI
                          Features                assistance

  PH-16                   Full-System Testing and Test, stabilize, and
                          Optimization            optimize the complete
                                                  system

  PH-17                   Release Preparation and Prepare approved
                          APK Delivery            release artifacts and
                                                  delivery
  -----------------------------------------------------------------------

**Current gate:** PH-00. Feature development must not begin until the
minimal cloud build proof has passed and the owner accepts the gate.

## 13. PH-00 acceptance criteria

PH-00 is complete only when all applicable criteria have evidence:

-   [ ] User has personally created or selected the GitHub repository.
-   [ ] User has personally reviewed and approved the Codemagic
    integration permissions.
-   [ ] Repository access is limited to the intended repository where
    supported.
-   [ ] No payment method, paid plan, or billing action was activated
    without explicit approval.
-   [ ] A minimal native Android project exists in the repository.
-   [ ] The cloud build workflow is configured for the actual project.
-   [ ] A cloud Debug build completes successfully.
-   [ ] The APK appears in build artifacts and can be downloaded.
-   [ ] Build record includes commit hash, build identifier, timestamp,
    and artifact name.
-   [ ] APK installation/launch is checked where a compatible
    device/emulator is available.
-   [ ] Known limitations and test evidence are recorded.
-   [ ] Owner explicitly accepts PH-00 before PH-01 begins.

If a criterion cannot be tested, mark it `NOT TESTED` with a reason. Do
not mark it as passed.

## 14. Current project status snapshot

As of the latest available conversation context on 2026-11-21:

  -----------------------------------------------------------------------
  Item                                Status
  ----------------------------------- -----------------------------------
  Project concept and scope           Described in planning discussions

  Documentation set SPB-DOC-001..017  Drafts identified; full approval
                                      not established

  Review set                          Reviews identified;
                                      preliminary/draft status must be
                                      preserved

  Review 013                          Skipped / not created

  Cloud-only development preference   Explicitly approved

  PH-00 initiation                    Explicitly requested

  GitHub/Codemagic connection         User chose to perform connection
                                      personally; no assistant-side
                                      connection

  Repository existence                Not confirmed in the latest
                                      available context

  Android starter project             Not confirmed as uploaded to GitHub

  Cloud build configuration           Template/planning exists;
                                      operational verification pending

  Successful cloud build              Not established

  Downloadable APK                    Not established

  PH-00 acceptance                    Pending

  Feature implementation              Not authorized to begin before
                                      PH-00 proof and acceptance
  -----------------------------------------------------------------------

A prior conversation summary records that a ZIP package named
`SPIDER_BROWSER_COMPLETE_STARTER_PACKAGE.zip` was previously generated
with 44 files, including documentation drafts, review drafts (001--012
and 014--017), phase plans, Kotlin/Gradle starter material, and a
`codemagic.yaml`. The available context also states that Gradle was not
actually run, no APK was produced, and GitHub upload/build/PH-00 closure
remained pending. This historical package should be checked against the
actual files before treating it as the current source of truth.

## 15. Recommended GitHub repository layout

``` text
spider-browser/
├── README.md
├── PROJECT_CONTEXT/
│   └── SPB-MASTER-001-MASTER-PROJECT-CONTEXT.md
├── docs/
│   ├── project/
│   │   ├── SPB-DOC-001-PROJECT-VISION.md
│   │   ├── SPB-DOC-002-PRD.md
│   │   ├── ...
│   │   └── SPB-DOC-017-CHANGELOG-DECISION-REGISTER.md
│   ├── reviews/
│   │   ├── SPB-REVIEW-001.md
│   │   ├── ...
│   │   ├── SPB-REVIEW-012.md
│   │   ├── SPB-REVIEW-014.md
│   │   ├── SPB-REVIEW-017.md
│   │   └── README-REVIEW-REGISTER.md
│   ├── phases/
│   │   ├── PH-00/
│   │   ├── PH-01/
│   │   └── ...
│   └── governance/
│       ├── SECURITY-RULES.md
│       ├── AI-CODING-RULES.md
│       └── APPROVAL-GATES.md
├── app/
├── gradle/
├── gradlew
├── settings.gradle.kts
├── build.gradle.kts
└── codemagic.yaml
```

The ellipses are placeholders, not files. Add only documents and source
files that actually exist and have been reviewed.

## 16. Decision log --- known decisions and pending decisions

### Approved / explicitly requested

-   Android target.
-   Cloud-based development.
-   Maximum documentation depth.
-   Provider-neutral AI coding assistant preference.
-   PH-00 first, with cloud build proof and Debug APK before feature
    work.
-   User personally handles GitHub/Codemagic linking.
-   No account action, permission grant, or cost without explicit
    approval.

### Proposed, not yet proven or finally approved

-   GitHub + optional Codespaces + Codemagic workflow.
-   Kotlin and native Android / Jetpack-based implementation.
-   Specific Gradle and Codemagic machine configuration.
-   Any exact package/application ID, SDK version, dependency versions,
    or final module boundaries.

### Pending

-   Confirm repository name and existence.
-   Confirm actual GitHub/Codemagic integration state.
-   Confirm exact permissions requested by the GitHub App.
-   Confirm available free build environment and current quota.
-   Confirm Android starter project contents.
-   Run and verify first cloud Debug build.
-   Record APK artifact and test evidence.
-   Obtain explicit PH-00 acceptance.

## 17. How to use this file

1.  Add this file to the GitHub repository at
    `PROJECT_CONTEXT/SPB-MASTER-001-MASTER-PROJECT-CONTEXT.md` or at the
    repository root.
2.  Use it as the project index and governance reference.
3.  Add the full SPB-DOC and SPB-REVIEW documents as separate files when
    available.
4.  Keep document statuses accurate.
5.  Update the decision log and status snapshot whenever the owner makes
    a new decision.
6.  Do not start PH-01 or feature implementation until PH-00 acceptance
    criteria are met.

------------------------------------------------------------------------

**End of document.**
